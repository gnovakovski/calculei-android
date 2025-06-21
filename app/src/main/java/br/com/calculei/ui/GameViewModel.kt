package br.com.calculei.ui

import br.com.calculei.model.Option

open class GameViewModel {

    private fun generateListOfOptions(): List<Option> {
        val results = mutableListOf(1,2,3,4,5,6,7,8,9)
        val options = mutableListOf<Option>()

        for (i in 0 until 3) {
            val optionResults = results.shuffled().take(3)
            options.add(Option(i + 1, optionResults))
        }

        for (i in 3 until 6) {
            val optionResults = results.shuffled().take(3)
            options.add(Option(i + 1, optionResults))
        }

        for (i in 6 until 9) {
            val optionResults = results.shuffled().take(3)
            options.add(Option(i + 1, optionResults))
        }

        return options
    }

    open fun createMatrixOfButtons(): Array<Array<Option>> {
        val results = generateListOfOptions()
        return arrayOf(
            arrayOf(results[0], results[1], results[2]),
            arrayOf(results[3], results[4], results[5]),
            arrayOf(results[6], results[7], results[8])
        )
    }
}