package com.example.mvpcalc.contract

interface ContractInterface {

    interface View {
        fun initViews()
        fun displayResult()
    }

    interface Presenter {
        fun performOperation(firstNum: Int, secondNum: Int)
        fun getResult(): String
        fun getOperand()
        fun setOperand(operand:String)
    }

    interface Model {
        fun add(firstNum:Int, secondNum:Int)
        fun substr(firstNum: Int, secondNum: Int)
        fun multiply(firstNum:Int, secondNum:Int)
        fun divide(firstNum:Int, secondNum:Int)
        fun getResult(): Int
        fun getOperand(): String
        fun setOperand(operand:String)
    }
}