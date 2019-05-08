package com.example.salesregisterkata.ui.home;

public interface HomeContract {
    interface View {
        void showResult(String result);
    }

    interface Presenter {
        void calculateTotal(String label, String quantity, String individualPrice, String stateCode);
    }
}
