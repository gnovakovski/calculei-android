package br.com.calculei.ui

import br.com.calculei.model.Question

open class GameViewModel {

    private fun generateListOfOptions(): List<Question> {
        val results = mutableListOf(1,2,3,4,5,6,7,8,9)
        val options = mutableListOf<Question>()

        val correctAnswer = results.shuffled().first()

        for (i in 0 until 3) {
            val optionResults = results.shuffled().take(3)
            options.add(Question(i + 1, optionResults, correctAnswer))
        }

        for (i in 3 until 6) {
            val optionResults = results.shuffled().take(3)
            options.add(Question(i + 1, optionResults, correctAnswer))
        }

        for (i in 6 until 9) {
            val optionResults = results.shuffled().take(3)
            options.add(Question(i + 1, optionResults, correctAnswer))
        }

        return options
    }

    open fun createMatrixOfQuestions(): Array<Array<Question>> {
        val results = generateListOfOptions()
        return arrayOf(
            arrayOf(results[0], results[1], results[2]),
            arrayOf(results[3], results[4], results[5]),
            arrayOf(results[6], results[7], results[8])
        )
    }

    fun updateAnswers(updatedAnswers: List<Int>) {

    }
}