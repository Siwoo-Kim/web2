package com.siwoo.webappag1.support;

import com.siwoo.webappag1.domain.*;
import com.siwoo.webappag1.domain.embedded.BasicTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Component
public class FixtureFactory {

    public static List<Topic> javaTopics(Category category, String hostname, int port) {
        List<Topic> topics = new ArrayList<>();
        try{
            Topic topic = new Topic();
            topic.setName("변수");
            topic.setCategory(category);
            topic.setDescription("영어로는 Variable로 (문자나 숫자 같은) 데이터를 담는 컨테이너다. 여기에 담겨진 데이터는 다른 데이터로 바꿀 수 있다. 변수는 마치 (사람이 쓰는 언어인) 자연어에서 대명사와 비슷한 역할을 한다.");
            topic.setDocuments(
                    Arrays.asList(
                            new Document("변수의 선언과 할당","int a;\n" + "\n" + " \n" + "\n" + "위의 구문은 변수 a를 지금부터 사용하겠다고 변수를 선언한 것이다. 변수 a 앞에는 int라는 키워드가 있다. 이 키워드는 integer의 약자로 한국어로는 정수라는 의미다. 정수는 0을 중심으로 -1, -2, -3과 같은 음수와 1, 2, 3과 같은 양수를 통틀어서 정수라고 한다. 위의 코드는 변수 a가 정수를 담는 그릇임을 명시한 것이다. 이 변수를 사용하는 입장에서는 이 변수 안에 들어있는 데이터가 틀림 없이 정수라는 것을 확신 할 수 있게 된다.\n" + "\n" + "a = 1;\n" + "\n" + "좌항의 변수 a의 데이터가 1이라는 의미다. a에 숫자 1을 대입한 것이다. 이제부터 a 안에는 1이 들어있다. 이러한 것을 변수 a에 숫자 1을 할당했다고 한다.\n" + "\n" + "위의 실습 결과는 각각 2와 3이 출력될 것이다. 변수 a에 담겨 있는 값이 1일 때는 a+1의 결과가 2가 된다. 두번째 결과가 3이 된 것은 a의 값이 2로 바뀌었고, 2+1의 결과인 3이 출력된 것이다."),
                            new Document("실수","아래 예제는 실수를 담는 방법이다. (실습)\n" + "\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "double a = 1.1; \n" + "System.out.println(a+1.1); // 2.2\n" + " \n" + "a = 2.1; \n" + "System.out.println(a+1.1); // 3.2\n" + "이번에는 변수 a의 앞에 double이 붙었다. double이 붙으면 변수가 실수를 담는 그릇이라는 의미가 된다. 실수와 정수를 구분하기 어렵다면 정수는 소수점이 없는 수, 실수는 소수점이 있는 수라고 생각하자. 1은 정수이고, 1.1은 실수이다.\n" + "\n" + "인간이 고안한 최초의 숫자는 자연수였다. 자연수의 핵심은 헤아림이다. 가족이 몇명인지, 가축은 몇마리인지를 헤아라기 위해서 1, 2, 3과 같은 숫자가 고안되었다. 그 후에 등장한 것이 정수다. 정수의 핵심은 0이다. 일반적으로 0은 없다(無)의 의미가 강조 되지만 정수에서의 0은 기준점으로서의 0이다. 온도를 생각해보자. 0도는 단지 인간에게 가장 중요한 물질인 물이 얼기 시작하는 온도를 의미한다."),
                            new Document("문자열","변수의 한자는 變數이다. 즉 변할 수 있는 수라는 뜻이다. 하지만 한자의 의미와 다르게 프로그래밍에서의 변수에는 다양한 데이터 형이 담겨질 수 있다. 다음 예제는 변수의 값이 꼭  숫자가 와야 하는 것은 아니라는 것을 보여주기 위해서 만든 예제다. (실습)\n" + "\n" + "1\n" + "2\n" + "String first = \"coding\"; \n" + "System.out.println(first+\" \"+\"everybody\");\n" + "문자열을 변수에 담을 때는 위와 같이 변수의 이름 앞에 String을 붙여준다.\n" + "\n" + "아래와 같이 여러개의 변수(a,b)를 동시에 선언 할 수도 있다. (실습)\n" + "\n" + "1\n" + "2\n" + "3\n" + "4\n" + "String a, b;\n" + "a = \"coding\";\n" + "b = \" everybody\";\n" + "System.out.println(a+b);\n" + "다음은 자바스크립트에서 변수를 대입하는 장면이다. (실습)\n" + "\n" + "1\n" + "2\n" + "3\n" + "a = 10;\n" + "b = 22.2;\n" + "alert(a+b);\n" + "변수 a와 b에는 각각 정수와 실수가 입력되고 있다. 자바스크립트는 자바와 다르게 변수의 값으로 어떠한 값도 들어올 수 있다. 까다롭게 정수와 실수를 구분하지 않아도 된다. 이런 이유로 자바스크립트와 같은 언어는 배우고 사용하기가 쉽다. 정수와 실수의 개념을 몰라도 되기 때문이다. 하지만 변수 a만 보고는 변수 안에 정수가 들어있는지 숫자가 들어있는지 파악 할 수 있는 방법이 없다. 이것은 아래와 같은 문제를 야기할 수 있다."),
                            new Document("Null","변수는 코드의 재활용성을 높여준다. 예를 들어서 100에 10을 더하고, 10을 나눈 후에 다시 10을 빼고 거기에 10을 곱해야 한다고 치자. 그리고 각 단계마다 그 결과를 출력해야 한다면 코드는 아래와 같을 것이다.System.out.println(100 + 10);\n" + "System.out.println((100 + 10) / 10);\n" + "System.out.println(((100 + 10) / 10) - 10);\n" + "System.out.println((((100 + 10) / 10) - 10) * 10);"))
            );
            topic.setBasicTime(new BasicTime(LocalDateTime.of(2018,04,10,1,10,10), null));
            topic.setReferences(Arrays.asList(new URL("http", hostname, port, "/language/" )));
            topics.add(topic);

            topic = new Topic();
            topic.setName("주석과 세미콜론");
            topic.setCategory(category);
            topic.setDescription("주석(comment)은 로직에 대한 설명이나 코드를 비활성화 할 때 사용한다. 주석은 프로그래밍적으로 해석되지 않는다.");
            topic.setDocuments(
                    Arrays.asList(
                            new Document("한줄 주석","public static void main(String[] args) {\n" + "    // 두개의 변수가 같은 데이터 타입 일 때 아래와 같이 코드를 작성한다.\n" + "    String a, b;\n" + "}"),
                            new Document("여러줄 주석","public static void main(String[] args) {\n" + "    String a, b;\n" + "    /*\n" + "    a = \"coding\";\n" + "    b = \"everybody\";\n" + "    System.out.println(a+b);\n" + "    */\n" + "}"),
                            new Document("세미콜론","세미콜론은 문장(statement)의 끝을 의미한다. 자바에서는 문장의 끝에 세미콜론을 사용하지 않으면 컴파일 에러가 발생한다. \n" + "\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "// assignment statement\n" + "aValue = 8933.234;\n" + "// increment statement\n" + "aValue++;\n" + "// method invocation statement\n" + "System.out.println(\"Hello World!\");\n" + "// object creation statement\n" + "Bicycle myBike = new Bicycle();\n" + "세미콜론을 이용하면 여러개의 문장을 한줄에 표현할 수 있다.\n" + "\n" + "1\n" + "int a = 100; double b = 10.1;")));
            topic.setBasicTime(new BasicTime(LocalDateTime.of(2018,4,10,7,10,32), null));
            topics.add(topic);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return topics;
    }

    public static List<Category> languageCategories(String hostname, int port) {
        List<Category> categories = new ArrayList<>();
        try {
            Category category = new Category();
            category.setName("JAVA");
            category.setIntroduction("본 모듈은 자바 언어에 대한 기초 수업입니다. 텍스트 수업과 동영상 수업이 함께 제공 됩니다. 텍스트만으로도 완주 하실 수 있고, 동영상만으로도 완주 할 수 있도록 구성 되었습니다. 동시에 텍스트가 이해 안되면 동영상으로, 동영상이 이해 안되면 텍스트를 통해서 상호 보안적으로 학습하실 수 있습니다. 모든 동영상을 연속적으로 시청하고 싶으시면 Youtube 자바 입문 수업 재생목록을 이용하시면 됩니다.");
            category.setLevel(Level.INTERMEDIATE);
            category.setPrerequisite("없습니다. 하지만, 프로그램을 처음 시작하는 분이라면 자바보다는 JavaScript나 Python, Ruby, PHP와 같은 언어를 먼저 해보실 것을 권합니다. 또는 생활코딩의 웹서비스 만들기 수업을 완주하신 후에 본 수업을 들으셔도 좋습니다. 자바는 조금 어렵기 때문입니다.");
            category.setDescription("최소한 국내에서 자바는 가장 시장 규모가 큰 언어입니다. 기업용 시장에서는 전통적인 강자였고, 안드로이드가 주류가 되면서 다시 한 번 그 중요성이 커지고 있는 언어입니다. 또한 자바는 거대 규모의 소프트웨어를 만드는데 적합한 언어입니다. 따라서 웅장한 소프트웨어를 만들기 위해서 필요한 다양한 연구와 자료가 풍부한 언어입니다. 자바를 배운다는 것은 이러한 성취에 접근 할 수 있는 손쉬운 방법이기도 합니다. ");
            category.setBasicTime(new BasicTime(LocalDateTime.of(2018,4,9,4,40,31),null));
            category.setUrl(new URL("http", hostname, port, "/category/"  ));
            categories.add(category);

            category = new Category();
            category.setName("JavaScript");
            category.setIntroduction("이 수업은 JavaScript라는 언어의 문법 수업입니다. 코딩이 처음인 분에게는 문법 중심으로 진행되는 수업이 지루하게 느껴질 수 있습니다. 그래서 생활코딩에서는 해결하고 싶은 문제를 중심으로 그 문제를 해결하는데 필요한 문법을 맥락적으로 챙겨드리는 수업을 준비했습니다. 이 수업을 먼저 보실 것을 권해드립니다.");
            category.setLevel(Level.NOVICE);
            category.setPrerequisite("없습니다. 여기서 시작하시면 됩니다. 하지만 프로그래밍을 처음 시작하는 분이라면 프로그래밍을 통해서 실제 제품을 어떻게 만드는가에 대한 전체적인 모습을 보여드리기 위한 수업인 생활코딩의 웹서비스 만들기 수업을 완주하신 후에 본 수업을 들으셔도 좋습니다.");
            category.setDescription("자바스크립트는 웹브라우저 위에서 동작하는 언어입니다. 만약 여러분이 웹프로그래밍을 하려고 한다면 자바스크립트는 사실상 필수라고 할 수 있습니다. 최근에는 node.js라는 서버측 자바스크립트가 각광받고 있습니다. 또한 MongoDB와 같은 친 JavaScript 데이터베이스를 사용하면 클라이언트부터 서버 그리고 데이터베이스까지 모든 부분을 JavaScript 기반으로 구현할 수 있습니다. 또한 구글 Apps 스크립트등의 사례에서도 볼 수 있듯이 자바스크립트는 다양한 플랫폼을 프로그래밍적으로 제어하기 위한 도구로 폭넓게 채택되고 있습니다. JavaScript의 시대라고 할만합니다. 자바스크립트의 모든 문법을 처음부터 배울 필요는 없습니다. 뒤로갈수록 어렵지만 어떤 특별한 상황에서 드물게 필요한 기능입니다. 앞에서 배우는 것일수록 쉽고, 보편적으로 사용되는 기능입니다. 만약 자바스크립트가 처음이라면 우리 수업에서 함수까지만 우선 공부하시고, 자바스크립트로 할 수 있는 일로서 웹브라우저 제어하기 수업이나 또는 서버 쪽 자바스크립트 수업을 보시면 좋을 것 같습니다. ");
            category.setBasicTime(new BasicTime(LocalDateTime.of(2018,4,9,4,40,31),LocalDateTime.of(2018,4,19,6,33,22)));
            category.setUrl(new URL("http", hostname, port, "/category/"  ));
            categories.add(category);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.error("URL Format is wrong");
            throw new RuntimeException(e);
        }
        return categories;
    }


    public static List<WebPage> webPages(String hostname, int port) {
        List<WebPage> webPages = new ArrayList<>();
        try {
            WebPage webPage = new WebPage();
            webPage.setName("MAIN");
            webPage.setGreeting("TryCode의 세계에 오신 것을 환영합니다. 어떻게 공부할 것인가를 생각해보기 전에 왜 프로그래밍을 공부하는 이유에 대한 이유를 함께 생각해보면 좋을 것 같습니다. 아래 영상을 한번 보시죠.");
            webPage.setIntroduction("입문자의 가장 큰 고충은 '무엇을 모르는지 모르는 상태'일 겁니다. 온라인에는 프로그래밍을 익히는 데 필요한 거의 모든 정보가 있지만, 이 지식들은 게시판이나 블로그 또는 커뮤니티에 포스팅 단위로 파편화되어 있습니다. 그래서 최소한 무엇을 검색해야 하는지를 아는 사람들을 위해서는 더 없이 좋은 공간이지만, '무엇을 모르는지 모르는 상태'의 입문자에게는 그림의 떡으로 남아 있습니다. 다시말해서 전문가를 더욱 전문가답게 만드는 혁신에 머물고 있는 것이죠. 오늘날은 인터넷이 연결된 환경에서 일을 합니다. 언제든지 검색하고, 질문할 수 있습니다. 또 많은 일을 기계가 대신해줍니다. 이런 시대의 공부방법은 과거와 달라져야 한다고 생각합니다.  TryCode이 지향하는 목표는 작은 교육입니다. 작은교육의 핵심은 '무엇을 모르는지 모르는 상태'에서 '무엇을 모르는지는 아는 상태'가 되는 것입니다. 무엇을 모르는지를 알면, 지금 당장 그 지식을 익히지는 않더라도, 그 지식이 정말 필요할 때 그 지식을 구하려 할 것입니다. 이 때 하는 공부는 이전과 같지 않을 것입니다. TryCode 주력 수업인 WEBn은 프로그래밍이 처음인 분들을 위해서 고안된 수업입니다. WEBn을 통해서 교양으로 코딩을 공부하려는 분들에게는 출구를, 직업으로 코딩을 공부하려는 분들에게는 입구를 제공해드리려고 노력하고 있습니다. 웹이라는 구체적인 사례를 통해서 코딩이 무엇인가 파악해보세요. 또 코딩을 통해서 웹을 만드는 방법을 공부해보세요. ");
            webPage.setDescription("각각의 수업의 하단에는 댓글이 있습니다. 이 댓글을 통해서 질문을 받습니다. 댓글을 달면 운영자에게 이메일이 발송되기 때문에 질문은 모두 운영자에게 열람이 됩니다. 하지만 많은 양의 질문을 받기 때문에 운영자 입장에서는 큰 부담이 되는 것도 사실입니다. 운영자가 답장을 하지 않는 것은 운영자도 잘 모르는 문제이거나 지금은 답변하기 어려운 것일 수 있습니다. 꼭 운영자를 통해서 문제를 해결해야 하는 것은 아니기 때문에 우선은 검색이나 커뮤니티에 질문하는 것을 통해서 문제를 해결하셨으면 좋겠습니다. 물론 운영자에게 질문하시는 것을 주저하실 필요는 없습니다. 답변할 수 있는 것은 최대한 신속하게 도움을 드립니다. 그리고 질문은 최대한 상세하게 해주세요.");
            webPage.setHelp(" 문의 사항은 sm123tt@gmail.com으로 연락 부탁드립니다.");
            webPage.setAim("일반인들에게 프로그래밍을 알려주는 무료 온라인, 오프라인 수업입니다. ");
            webPage.setBasicTime(new BasicTime(LocalDateTime.of(2018, 04, 9, 2, 17, 0), LocalDateTime.of(2018, 04, 9, 2, 17, 0)));
            webPage.setUrl(new URL("http", hostname, port, "/" + webPage.getName()));
            Map<String,String> images = new HashMap<>();
            images.put("name","/assets/img/webPage/name.png");
            images.put("introduction","/assets/img/webPage/introduction.png");
            images.put("greeting","/assets/img/webPage/greeting.png");
            images.put("description","/assets/img/webPage/5555.png");
            images.put("aim","/assets/img/webPage/aim.png");
            images.put("help","/assets/img/webPage/help.png");
            webPage.setImages(images);
            webPages.add(webPage);

            webPage = new WebPage();
            webPage.setName("LANGUAGE");
            webPage.setGreeting("TryCode의 언어 페이지에 오신것을 환영합니다.");
            webPage.setIntroduction("언어(language)는 그 언어를 사용하는 주체들 간의 약속입니다. 사람과 사람이 소통 할 수 있는 것은 어떠한 소리나 기호에 대한 약속을 서로가 공유하고 있기 때문입니다. &#39;안녕&#39;이라는 음가가 인사라는 약속이 되어 있기 때문에 사람들은 만나는 즐거움과 헤어지는 아쉬움을 상대방에게 전달 할 수 있는 것이죠. 마찬가지로 프로그래밍 언어도 약속입니다. 사람과 기계(컴퓨터)와의 약속입니다. 기계도 이해할 수 있고 사람도 이해할 수 있는 언어의 규칙에 따라서 사람이 원하는 것을 기계에게 전달하면 기계는 그 기호의 의미에 따라서 동작하게 되는 것입니다.");
            webPage.setDescription("본 코스는 언어들에 대한 수업을 모아둔 코스입니다. Python, Ruby처럼 오늘날 광범위하게 사용되고 있는 언어부터 지금은 사용하지 않지만 언어의 발전 단계에서 중요한 의미를 갖는 포트란 같은 고대언어를 망라할 예정입니다. 그리고 각각의 언어 수업들이 독립적인 완결성을 가지면서, 동시에 초심자의 입장에서 쓰여졌기 때문에 프로그래밍의 진입점으로 어떤 언어 수업을 선택하셔도 무방하도록 수업을 구성했습니다. 동시에 장르적인 접근을 하고 있기 때문에 기존의 프로그래머들도 새로운 언어를 빠르게 습득 할 수 있는 입문서로도 활용될 수 있도록 했습니다. 하지만 프로그래밍 입문자는 무엇을 모르는지 모르는 상태에 있기 때문에 알아서 선택하라고 하면 어려움을 겪습니다. 그래서 필자가 권장하는 방식은 쉬운 언어를 먼저 배우고, 필요에 따라서 어려운 언어로 나아가는 전략입니다. 프로그래밍 입문으로 배우기 좋은 언어는 JavaScript, Python, Ruby, PHP 정도를 이야기 할 수 있을 것 같습니다. 이 언어들은 많은 곳에서 활용되면서 또 배우기 수월하다는 점이 큰 장점입니다. 물론 여기에도 정답은 없습니다. 근본부터 파고드는 것을 좋아하고, 거대한 학습 버퍼(buffer)를 가지고 있다면 어셈블리어나 C와 같은 저수준의 언어부터 활용도가 많은 고수준의 언어로 나아가는 것도 좋은 방법입니다. 하지만 지치지 않도록 조심하시길 바랍니다");
            webPage.setHelp(" 문의 사항은 sm123tt@gmail.com으로 연락 부탁드립니다.");
            webPage.setAim("일반인들에게 기본적인 프로그래밍 언어를 알려주는 페이지입니다");
            webPage.setBasicTime(new BasicTime(LocalDateTime.of(2018, 04, 9, 4, 17, 0), LocalDateTime.of(2018, 04, 9, 6, 36, 40)));
            webPage.setUrl(new URL("http", hostname, port, "/" + webPage.getName()));
            images = new HashMap<>();
            images.put("name","/assets/img/webPage/name.png");
            images.put("introduction","/assets/img/webPage/introduction.png");
            images.put("greeting","/assets/img/webPage/greeting.png");
            images.put("description","/assets/img/webPage/5555.png");
            images.put("aim","/assets/img/webPage/aim.png");
            images.put("help","/assets/img/webPage/help.png");
            webPage.setImages(images);
            webPages.add(webPage);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.error("URL Format is wrong");
            throw new RuntimeException(e);
        }
        return webPages;
    }
}
