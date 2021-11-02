# 반복자 패턴

객체 요소들의 내부 표현방식은 공개하지 않으면서 외부에서 객체에 순회하는 방식

자바 컬렉션중의 `Iterator`를 생각하면 된다.

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/139759722-92c27293-df40-4411-aa1b-2310395ac14b.png)

자바의 컬렉션인 `List`만 일단 보게되었는데

![image](https://user-images.githubusercontent.com/74235102/139790450-8ba37642-2d77-44c6-803e-1dcb60a048d7.png)

![image](https://user-images.githubusercontent.com/74235102/139790521-fcab29c7-f228-4b98-bd7c-2ea2db670a02.png)

![image](https://user-images.githubusercontent.com/74235102/139790543-5a41ad2f-faef-48c2-afb1-3bd627a37bf3.png)

컬렉션 내부들에는 다 `Iterator`를 구현하고 있다.