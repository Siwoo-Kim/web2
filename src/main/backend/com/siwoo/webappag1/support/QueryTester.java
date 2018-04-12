package com.siwoo.webappag1.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
public class QueryTester {

    public void doQuery(EntityManager entityManager) {
        try(Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            for(;;) {
                System.out.printf("JPQL:>");
                String query = scanner.nextLine();
                if(query.toUpperCase().equals("Q")) {
                    System.exit(1);
                }
                if(query.length() == 0) {
                    continue;
                }

                try {
                    List result = entityManager.createQuery(query).getResultList();
                    if(result.size() > 0) {
                        int count = 0;
                        for(Object rows : result) {
                            System.out.printf("@@@@@Data #" + (++count) + " = ");
                            printResult(rows);
                        }
                    } else {
                        System.out.println("@@@@@No Data , try again.");
                    }
                }catch (Exception e) {
                    log.error("Error " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    private void printResult(Object rows) {
        if(rows == null) {
            System.out.println(" null ");
        }else if (rows instanceof Object[]) {
            Object[] row = (Object[]) rows;
            for(int i=0; i < row.length ; i++) printResult(row[i]);
        }else if(rows instanceof Long ||
                 rows instanceof Double ||
                 rows instanceof String) {
            System.out.printf(rows.getClass().getSimpleName()+":" + rows + ", ");
        } else {
            System.out.printf(rows.getClass().getSimpleName() + ":" + rows + ", ");
        }
        System.out.println("================================================================");
    }


}
