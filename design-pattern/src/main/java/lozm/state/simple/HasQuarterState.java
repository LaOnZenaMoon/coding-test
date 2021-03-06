package lozm.state.simple;

import java.util.Random;

public class HasQuarterState implements State {

    BallMachine ballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());


    public HasQuarterState(BallMachine ballMachine) {
        this.ballMachine = ballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("동전은 한 개만 넣어주세요.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전이 반환됩니다.");
        ballMachine.setState(ballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌리셨습니다.");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (ballMachine.getCount() > 1)) {
            ballMachine.setState(ballMachine.getWinnerState());
        } else {
            ballMachine.setState(ballMachine.getSoldState());
        }

    }

    @Override
    public void dispense() {
        System.out.println("알맹이가 나갈 수 없습니다.");
    }

}
