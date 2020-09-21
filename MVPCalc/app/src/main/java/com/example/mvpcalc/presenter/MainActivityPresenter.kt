package com.example.mvpcalc.presenter

import com.example.mvpcalc.contract.ContractInterface.*
import com.example.mvpcalc.model.MainActivityModel

class MainActivityPresenter(__view: View): Presenter {

    private lateinit var operand:String

    override fun setOperand(operand: String) {
        model?.setOperand(operand)
    }

    private var view: View =__view
    private var model:Model = MainActivityModel()

    init {
        view.initViews()
    }

    override fun performOperation(firstNum:Int, secondNum:Int) {
        getOperand()
        when(operand) {
            "+" -> model?.add(firstNum, secondNum)
            "-" -> model?.substr(firstNum, secondNum)
            "*" -> model?.multiply(firstNum, secondNum)
            "/" -> model?.divide(firstNum, secondNum)
        }

        view.displayResult()
    }

    override fun getResult(): String {
        return model?.getResult().toString()
    }

    override fun getOperand() {
        operand = model?.getOperand()
    }

}