package com.example.firsttask

object IntRetranslator {
    private var toHundred = arrayOf(
        arrayOf(
            "",
            "од",
            "дв",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять"
        ),
        arrayOf(
            "",
            "десять ",
            "двадцать ",
            "тридцать ",
            "сорок ",
            "пятьдесят ",
            "шестьдесят ",
            "семьдесят ",
            "восемьдесят ",
            "девяносто "
        ),
        arrayOf(
            "",
            "сто ",
            "двести ",
            "триста ",
            "четыреста ",
            "пятьсот ",
            "шестьсот ",
            "семьсот ",
            "восемьсот ",
            "девятьсот "
        )
    )
    private var elevenToNineteen = arrayOf(
        "десять ",
        "одиннадцать ",
        "двенадцать ",
        "тринадцать ",
        "четырнадцать ",
        "пятнадцать ",
        "шестнадцать ",
        "семнадцать ",
        "восемнадцать ",
        "девятнадцать "
    )
    private var thousandsAndMillions =
        arrayOf(
            arrayOf("", "", "", ""),
            arrayOf("миллиардов ", "миллионов ", "тысяч ", ""),
            arrayOf("миллиард ", "миллион ", "тысяча ", ""),
            arrayOf("миллиарда ", "миллиона ", "тысячи ", ""),
            arrayOf("миллиардов ", "миллионов ", "тысяч ", "")
        )

    fun retranslate(number: Long): String {
        val text = ""
        if (number == 0L) {
            return "ноль"
        }
        val million = number.toInt() / 1000000
        val thousand = (number - million * 1000000).toInt() / 1000
        val lasts = (number % 1000).toInt()
        return text + toThousands(
            million,
            1
        ) + toThousands(thousand, 2) + toThousands(lasts, 3)
    }

    private fun toThousands(value: Int, index: Int): String {
        val hundreds = value / 100
        val decimal = (value - hundreds * 100) / 10
        val units = value % 10
        var text = ""
        text =
            if (decimal == 1) toHundred[2][hundreds] + elevenToNineteen[units] else toHundred[2][hundreds] + toHundred[1][decimal] + toHundred[0][units]

        if (index == 2) {
            if (units == 1 && decimal != 1) text += "на " else if (units == 2 && decimal != 1) text += "е "
            if (units > 1 && decimal != 1) text = "$text "
        } else {
            if (units == 1 && decimal != 1) text += "ин "
            if (units == 2 && decimal != 1) {
                text += "а "
            } else if (units != 0 && decimal != 1) text = "$text "
        }

        var indexA = 0
        if (value != 0) {
            indexA =
                if (units == 0 || decimal == 1) 1 else if (units == 1) 2 else if (units in 2..4) 3 else 4
        }
        text += thousandsAndMillions[indexA][index]
        return text
    }
}