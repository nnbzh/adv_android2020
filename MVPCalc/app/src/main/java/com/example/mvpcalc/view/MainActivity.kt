package com.example.mvpcalc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpcalc.R
import com.example.mvpcalc.contract.ContractInterface
import com.example.mvpcalc.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractInterface.View {

    private var presenter: MainActivityPresenter? = null
    private var firstNum = 0
    private var secondNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
    }

    override fun initViews() {
        result.text = presenter?.getResult()

        plus.setOnClickListener {
            if (number.text.isNotEmpty()) {
                firstNum = number.text.toString().toInt()
            }
            presenter?.setOperand("+")
            number.setText("")
        }

        minus.setOnClickListener {
            if (number.text.isNotEmpty()) {
                firstNum = number.text.toString().toInt()
            }
            presenter?.setOperand("-")
            number.setText("")
        }

        multiply.setOnClickListener {
            if (number.text.isNotEmpty()) {
                firstNum = number.text.toString().toInt()
            }
            presenter?.setOperand("*")
            number.setText("")
        }

        divide.setOnClickListener {
            if (number.text.isNotEmpty()) {
                firstNum = number.text.toString().toInt()
            }
            presenter?.setOperand("/")
            number.setText("")
        }

        equal.setOnClickListener {
            if (number.text.isNotEmpty()) {
                secondNum = number.text.toString().toInt()
            } else secondNum = 0
            presenter?.performOperation(firstNum, secondNum)
            number.setText("")
        }
    }

    override fun displayResult() {
        result.text = presenter?.getResult()
    }
}