public class QuizExpert {
    private static String[] questions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 2, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };
    private static int[] answers = {9, 8, 36, 13, 32};

    protected static String getQuiz(int index){
        return questions[index];
    }

    protected static int getAns(int index){
        return answers[index];
    }
}

