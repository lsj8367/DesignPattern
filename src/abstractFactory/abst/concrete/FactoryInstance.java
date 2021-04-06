package abstractFactory.abst.concrete;

import abstractFactory.abst.Button;
import abstractFactory.abst.GuiFac;
import abstractFactory.abst.TextArea;

public class FactoryInstance {

    public static GuiFac getGuiFac() {
        switch (1){
            case 0: return new MacGuiFac();
            case 1: return new LinuxGuiFac();
            case 2: return new WinGuiFac();

        }
        return null;
    }
}

class LinuxButton implements Button {
    @Override
    public void click() {
        System.out.println("리눅스 버튼");
    }
}

class LinuxGuiFac implements GuiFac {
    @Override
    public Button createButton() {
        // 여러가지 기능
        return new LinuxButton();
    }

    @Override
    public TextArea createTextArea() {
        //여러가지 기능
        return new LinuxTextArea();
    }
}

class LinuxTextArea implements TextArea {
    @Override
    public String getText() {
        return "리눅스 TextArea";
    }
}

class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("맥os 버튼");
    }
}

class MacGuiFac implements GuiFac {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}


class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "맥os TextArea";
    }
}

class WinButton implements Button {
    @Override
    public void click() {
        System.out.println("윈도우 버튼");
    }
}

class WinGuiFac implements GuiFac {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public TextArea createTextArea() {
        return new WinTextArea();
    }
}

class WinTextArea implements TextArea {
    @Override
    public String getText() {
        return "윈도우 TextArea";
    }
}