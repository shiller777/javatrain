package com.http.shiller.fifth;

import java.util.ArrayList;

public class Button {

    private OnClick onClick;

    public Button(OnClick onClick) {
        this.onClick = onClick;
    }

    public Button() {
        this.onClick = new DefaultOnClick();
    }

    public void clicked() {
        this.onClick.click();
    }

    interface OnClick {
        void click();

        default void down() {
            System.out.println("down");
        }
    }

    class DefaultOnClick implements OnClick {
        @Override
        public void down() {
            System.out.println("default down");
        }

        @Override
        public void click() {
            System.out.println("default click");
        }
    }

    public static class CustomList extends ArrayList<Integer> {
        @Override
        public Integer remove(int index) {
            return 0;
        }
    }
}

class TextButton extends Button {

    public TextButton(OnClick onClick) {
        super(onClick);
    }
}
