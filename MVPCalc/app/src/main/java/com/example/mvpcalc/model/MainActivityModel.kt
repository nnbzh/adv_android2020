package com.example.mvpcalc.model

import com.example.mvpcalc.contract.ContractInterface.*

class MainActivityModel : Model {

    private var result = 0
    private var operand = ""

    override fun setOperand(operand: String) {
        this.operand = operand
    }

    override fun getOperand(): String = operand

    override fun getResult(): Int = result

    override fun add(firstNum: Int, secondNum: Int) {
        result = firstNum + secondNum
    }

    override fun substr(firstNum: Int, secondNum: Int) {
        result = firstNum - secondNum
    }

    override fun multiply(firstNum: Int, secondNum: Int) {
        result = firstNum * secondNum
    }

    override fun divide(firstNum: Int, secondNum: Int) {
        result = firstNum/secondNum
    }

}