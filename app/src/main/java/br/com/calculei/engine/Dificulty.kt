package br.com.calculei.engine

class Dificulty (val value: Int) {
    companion object {
        val easy = mutableListOf("+", "-")
        val medium = mutableListOf("+", "-", "*")
        val hard = mutableListOf("+", "-", "*")

        fun getDificulty(value: Int): MutableList<String> {
            return when (value) {
                0 -> easy
                1 -> medium
                2 -> hard
                else -> easy
            }
        }

    }
}