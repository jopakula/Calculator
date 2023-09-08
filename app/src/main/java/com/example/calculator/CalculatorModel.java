package com.example.calculator;

import android.widget.Switch;

public class CalculatorModel {

    private int firstArg, secondArg;
    private StringBuilder inputStr = new StringBuilder();
    private int actionSelected;
    private State state;
    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

//    Вот тут эта хуйня не работает

//    public void onNumPressed(int buttonId) {
//
//        if (inputStr.length() >  9) {
//            switch (buttonId) {
//                case R.id.zero:
//                    if (inputStr.length() != 0) {
//                        inputStr.append("0");
//                    }
//                    break;
//                case R.id.one:
//                        inputStr.append("1");
//                    break;
//                case R.id.two:
//                    inputStr.append("2");
//                    break;

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() <  9) {
            if (buttonId == R.id.zero) {
                if (inputStr.length() != 0) {
                    inputStr.append("0");
                }
            } else if (buttonId == R.id.one) {
                inputStr.append("1");
            } else if (buttonId == R.id.two) {
                inputStr.append("2");
            } else if (buttonId == R.id.three) {
                inputStr.append("3");
            } else if (buttonId == R.id.four) {
                inputStr.append("4");
            } else if (buttonId == R.id.five) {
                inputStr.append("5");
            } else if (buttonId == R.id.six) {
                inputStr.append("6");
            } else if (buttonId == R.id.seven) {
                inputStr.append("7");
            } else if (buttonId == R.id.eight) {
                inputStr.append("8");
            } else if (buttonId == R.id.nine) {
                inputStr.append("9");
            }
        }
    }

    public void onActionPressed(int actionId) {

        if (actionId == R.id.equals && state == State.secondArgInput) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            if (actionSelected == R.id.plus) {
                inputStr.append(firstArg + secondArg);
                return;
            } else if (actionSelected == R.id.minus) {
                inputStr.append(firstArg - secondArg);
                return;
            } else if (actionSelected == R.id.multiply) {
                inputStr.append(firstArg * secondArg);
                return;
            } else if (actionSelected == R.id.division) {
                inputStr.append(firstArg / secondArg);
                return;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
        }

        if (actionId == R.id.plus) {
            actionSelected = R.id.plus;
            return;
        } else if (actionId == R.id.minus) {
            actionSelected = R.id.minus;
            return;
        } else if (actionId == R.id.multiply) {
            actionSelected = R.id.multiply;
            return;
        } else if (actionId == R.id.division) {
            actionSelected = R.id.division;
            return;
        } else if (actionId == R.id.equals) {
            actionSelected = R.id.equals;
            return;
        }

    }

    public String getText() {
        return inputStr.toString();
    }

}
