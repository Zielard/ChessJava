package FigureTests.TestQueen;

import com.company.Board;
import com.company.Figure.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class PawnsTest {

    BasePawn pawn;
    Engine engine;
    boolean result;
    String colorStr;
    int newX, oldX, enemyX = 0;
    int newY, oldY, enemyY = 0;

    int startLetter = 65;
    String boardStr = "⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝"+"/n"+
                      "⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞"+"/n"+
                      "⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝"+"/n"+
                      "⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞"+"/n"+
                      "⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝"+"/n"+
                      "⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞"+"/n"+
                      "⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝"+"/n"+
                      "⛝ ⛞ ⛝ ⛞ ⛝ ⛞ ⛝ ⛞"+"/n"+
                      "false";


    ///////////FOR MOVES

    @Given("We have a pawn {string} of the color {string} at the position {int}, {string}")
    public void createPawn(String name, String colorIn, Integer x, String y)
    {
        engine = new Engine();
        engine.initSetBoard(boardStr);

        result = false;
        colorStr = colorIn;

        this.oldX = x-1;
        this.oldY = (int)Character.toUpperCase(y.charAt(0)) - startLetter;

        //Set color /////////////////////
        boolean color_f = true;
        colorStr = colorStr.toLowerCase();
        if(colorStr.equals("black"))
        {
            color_f = true;
        }
        else if(colorStr.equals("white"))
        {
            color_f = false;
        }

        //Create Pawn////////////////////////////
        if (name.equals("King"))
        {
            pawn = new King(color_f);
            engine.getBoard().getBoardTable()[oldX][oldY].setGameObject(pawn);
        }
        else if(name.equals("Queen"))
        {
            pawn = new Queen(color_f);
            engine.getBoard().getBoardTable()[oldX][oldY].setGameObject(pawn);
        }
        else if(name.equals("Pawn"))
        {
            pawn = new Pawn(color_f);
            engine.getBoard().getBoardTable()[oldX][oldY].setGameObject(pawn);
        }
        else if(name.equals("Horse"))
        {
            pawn = new Horse(color_f);
            engine.getBoard().getBoardTable()[oldX][oldY].setGameObject(pawn);
        }
        else if(name.equals("Runner"))
        {
            pawn = new Runner(color_f);
            engine.getBoard().getBoardTable()[oldX][oldY].setGameObject(pawn);
        }
        else if(name.equals("Tower"))
        {
            pawn = new Tower(color_f);
            engine.getBoard().getBoardTable()[oldX][oldY].setGameObject(pawn);
        }
    }

    @When("We want go to {int}, {string}")
    public void moveTo(int xIn, String yIn)
    {
        this.newX = xIn-1;
        this.newY = (int)Character.toUpperCase(yIn.charAt(0)) - startLetter;
    }

    @Then("We can't go there")
    public void weCantGoToNewPos()
    {
        assertEquals(false, pawn.move(oldX,oldY,this.newX,this.newY,engine.getBoard().getBoardTable()));
    }

    @Then("We can go there")
    public void weCanGoToNewPos()
    {
        assertEquals(true, pawn.move(oldX,oldY,this.newX,this.newY,engine.getBoard().getBoardTable()));
    }

    ///////////FOR CAPTURE

    @When("We have another pawn {string} of the color {string} at the position {int}, {string}")
    public void createEnemyPawn(String name, String colorIn, Integer x, String y)
    {
        String colorStrE = colorIn;

        this.enemyX = x-1;
        this.enemyY = (int)Character.toUpperCase(y.charAt(0)) - startLetter;

        //Set color /////////////////////////////
        boolean color_f = true;
        colorStrE = colorStrE.toLowerCase();
        if(colorStrE.equals("black"))
        {
            color_f = true;
        }
        else if(colorStrE.equals("white"))
        {
            color_f = false;
        }

        //Create Pawn////////////////////////////
        if (name.equals("King"))
        {
            engine.getBoard().getBoardTable()[enemyX][enemyY].setGameObject(new King(color_f));
        }
        else if(name.equals("Queen"))
        {
            engine.getBoard().getBoardTable()[enemyX][enemyY].setGameObject(new Queen(color_f));
        }
        else if(name.equals("Pawn"))
        {
            engine.getBoard().getBoardTable()[enemyX][enemyY].setGameObject(new Pawn(color_f));
        }
        else if(name.equals("Horse"))
        {
            engine.getBoard().getBoardTable()[enemyX][enemyY].setGameObject(new Horse(color_f));
        }
        else if(name.equals("Runner"))
        {
            engine.getBoard().getBoardTable()[enemyX][enemyY].setGameObject(new Runner(color_f));
        }
        else if(name.equals("Tower"))
        {
            engine.getBoard().getBoardTable()[enemyX][enemyY].setGameObject(new Tower(color_f));
        }
    }

    @Then("We can capture another pawn")
    public void weCanCaptureAnotherPawn()
    {
        assertEquals(true, pawn.move(oldX,oldY,this.enemyX,this.enemyY,engine.getBoard().getBoardTable()));
    }

    @Then("We cant capture another pawn")
    public void weCantCaptureAnotherPawn()
    {
        assertEquals(false, pawn.move(oldX,oldY,this.enemyX,this.enemyY,engine.getBoard().getBoardTable()));
    }
}
