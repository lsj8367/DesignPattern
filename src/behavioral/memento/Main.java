package behavioral.memento;

import java.util.ArrayList;

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
                e.printStackTrace();
            }
            System.out.println();
        }
    }

}
