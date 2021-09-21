# 컴포지트 패턴

어떤 메뉴들에 대한 카테고리를 생각해보면

카테고리의 중분류 로 들어가서 세부 사항을 나열한 카테고리가

존재할 수도 있고, 아니라면 그냥 그 카테고리에서

끝나는 경우의 카테고리도 존재한다. 그러니까

부분과 전체에 대해 복합객체의 트리 구조를 나타낼 수 있다.

클라이언트가 개별 객체와 복합 객체를 동일하게 다룰 수가 있게 되는 것이다.

**재귀적인 구조**

![스크린샷 2021-09-22 오전 12 32 55](https://user-images.githubusercontent.com/74235102/134201243-91556746-21cb-4e0b-af3b-3c48b544ec48.png)

그림과 같이 재귀적인 구조가 형성이 되게 된다.

## 클래스 다이어그램

![스크린샷 2021-09-22 오전 12 34 21](https://user-images.githubusercontent.com/74235102/134201446-08abbd39-a2dd-48cb-9a90-20d319eda35e.png)

클래스 다이어 그램을 보면 위와 같이 구성이 된다.

그러니까 그냥 해당 객체의 기능만 수행하는 역할,

기능 + 자기 하위의 또 다른 객체들에 대한 정의가 들어간

그런 객체 두가지로 분류가 되는 다이어그램이다.

- Component
  - 전체와 부분 객체에서 공통적으로 사용할 인터페이스 선언
  - 전체와 부분 객체에서 공통으로 사용할 기능 구현
  - 전체 클래스가 부분요소들을 관리하기 위해 필요한 인터페이스 선언
- Leaf
  - 집합 관계에서 다른 객체를 포함할 수는 없고 포함되기만 하는 객체로 가장 기본이 되는 기능 구현
- Composite
  - 여러 객체를 포함하는 복합 객체에 대한 기능
  - 포함된 여러 객체를 저장, 관리하는 기능
- Client
  - 컴포넌트에 선언된 인터페이스를 통해 부분, 전체 동일처리

이렇게 보면 기본이 되는 객체는 복합 객체에 포함이 되고, 

복합객체도 다른 복합객체에 포함이 되는 재귀적 구조가 될 수 밖에 없다.

기본 객체가 증가해도 전체 객체 코드에는 영향을 주지 않는다.
