# 메멘토 패턴

어떤 객체가 전의 상태로 되돌아가려고 할 때 쓰는 패턴이다.

닥터 스트레인지를 봤다면 도르마무를 연상케 하는 패턴이다.

구현은 `ArrayList`로 구현했지만 여러가지 자료구조로 원하는 시점으로 가서 되돌리는 방법도 있을 수 있다.

## 클래스 다이어그램

![image](https://user-images.githubusercontent.com/74235102/136486927-3f54b05e-a8c3-429e-a5b1-ba9c87b2edce.png)

클래스 다이어그램은 위 이미지와 같다.

- `Memento`
  - `Originator` 예제에서는 `Gamer` 객체의 내부 상태를 필요한 만큼 저장한다.
- `Originator`
  - `Memento`를 생성하여 현재 객체 상태를 저장하고 내부 상태를 복원해준다.
  - 이 객체만이 `Memento`에 접근이 가능하다.
- `CareTaker`
  - `Memento`를 저장해주기는 하나, 내부에 관여하지 못함

`Originator`의 내부 상태를 다른 객체로 분리함으로써 캡슐화가 가능하다.

단점이라고 한다면 결국 이 메멘토라는 객체도 어느 용량의 한계가 있을 것인데

그것에 대한 오버헤드 발생 우려가 있다.

```java
public class Gamer {
    private int money;
    private ArrayList<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] FRUIT_NAME = {"사과", "포도", "바나나", "귤"};

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("돈이 증가했습니다.");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("돈이 반으로 줄었습니다.");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("과일(" + f + ")을 받았습니다.");
            fruits.add(f);
        } else {
            System.out.println("아무일도 일어나지 않았습니다.");
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento(money);
        if (Objects.nonNull(fruits)) {
            fruits.stream().filter(fruit -> fruit.startsWith("good")).forEach(memento::addFruit);
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }


    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "good";
        }

        return prefix + FRUIT_NAME[random.nextInt(FRUIT_NAME.length)];
    }

    @Override
    public String toString() {
        return "Gamer{" +
            "money=" + money +
            ", fruits=" + fruits +
            '}';
    }
}
```

```java
public class Memento {
    private int money;
    ArrayList<String> fruits;

    public Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<String> getFruits() {
        return fruits;
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }
}
```

```java
public class Main {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        ArrayList<Memento> history = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            System.out.println("====" + i);
            System.out.println("현 상태: " + gamer);

            gamer.bet();

            System.out.println("돈은 " + gamer.getMoney() + "원이 되었습니다.");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("돈 증가해서 저장");
                memento = gamer.createMemento();
                history.add(memento);
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("돈이 줄어서 복원함");
                gamer.restoreMemento(memento);
            }


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }

}
```

![image](https://user-images.githubusercontent.com/74235102/136488033-df14a6e4-0af8-412a-a4e5-d3d7fe6bd335.png)

복원될 때 good이 붙은 과일과 그전의 가지고 있던 돈 상태로 복원을 시켜준다.