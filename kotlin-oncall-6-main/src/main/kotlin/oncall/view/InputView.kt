package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readDate(): String {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
        val input = Console.readLine()
        return input
    }
}