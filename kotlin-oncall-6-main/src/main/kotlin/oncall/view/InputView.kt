package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readDate(): String {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
        val input = Console.readLine()
        return input
    }

    fun readWeekdayWorkers(): List<String> {
        print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
        val input = Console.readLine()
        return input.split(",")
    }

    fun readWeekendWorkers(): List<String> {
        print("주말 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
        val input = Console.readLine()
        return input.split(",")
    }
}