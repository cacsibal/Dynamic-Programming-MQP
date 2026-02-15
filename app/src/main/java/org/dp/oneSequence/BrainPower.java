package org.dp.oneSequence;

import org.dp.IBottomUp;

/**
 * Name: Solving Questions With Brainpower
 * Description:
 * You are given a 0-indexed 2D integer array questions where questions[i] = [points_i, brainpower_i].
 *
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
 *
 * For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 */
public class BrainPower implements IBottomUp {

    int[][] questions;

    public BrainPower(int[][] questions) {
        this.questions = questions;
    }

    public long helper_bottomup() {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skip = questions[i][1];

            long solve = points;
            int next = i + skip + 1;
            if (next < n) {
                solve += dp[next];
            }

            long skipQuestion = dp[i + 1];

            dp[i] = Math.max(solve, skipQuestion);
        }

        return dp[0];
    }

    public long solution_bottomup(){
        return helper_bottomup();
    }

    public long solution(){
        return helper_bottomup();
    }
}
