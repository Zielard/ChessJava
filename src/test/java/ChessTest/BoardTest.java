package ChessTest;

import com.company.Figure.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    List<String> templatesBoard = Arrays.asList(
            "boardTempForTest\\ForLoadOnly\\example_1.txt",
            "boardTempForTest\\ForLoadOnly\\example_2.txt",
            "boardTempForTest\\ForLoadOnly\\example_3.txt");

    List<String> templatesBoardForCheck = Arrays.asList(
            "boardTempForTest\\CheckMate\\checkMate_1.txt",
            "boardTempForTest\\CheckMate\\checkMate_2.txt",
            "boardTempForTest\\CheckMate\\checkMate_3.txt",
            "boardTempForTest\\CheckMate\\checkMate_4.txt",
            "boardTempForTest\\CheckMate\\checkMate_5.txt",
            "boardTempForTest\\CheckMate\\checkMate_6.txt");

    Engine engine;
    int result = 1;
    boolean checkState = false;
    ///////////FOR MOVES

    @Given("We have a board temp number {int}")
    public void loadBoard(Integer number)
    {
        engine = new Engine();
        engine.getBoard().loadBoardFromFile(templatesBoard.get(number));
    }

    @Given("We have a board temp for check by number {int}")
    public void loadBoardcheck(Integer number)
    {
        engine = new Engine();
        engine.getBoard().loadBoardFromFile(templatesBoardForCheck.get(number));
    }

    @Given("We init default board")
    public void initBoard()
    {
        engine = new Engine();
        engine.initDefaultBoard();
    }

    @Given("We set default state to board")
    public void weSetDefaultStateToBoard()
    {
        engine.initDefaultBoard();
    }
    ////////////////////
    @When("We have checkmate, {string} King")
    public void WeHaveCheckmateByColorKing(String color)
    {
        //Set color /////////////////////
        boolean color_f = true;
        color = color.toLowerCase();
        if(color.equals("black"))
        {
            color_f = true;
        }
        else if(color.equals("white"))
        {
            color_f = false;
        }
        checkState = engine.getBoard().checkMate(color_f);
        int tra= 0;
    }

    @Then("We have checkmate")
    public void Wehavecheckmate()
    {
        assertEquals(true, checkState);
    }

    @Then("We havent checkmate")
    public void Wehaventcheckmate()
    {
        assertEquals(false, checkState);
    }
    ////////////////////
    @When("We want go to {int}, {string}, by {int}, {string}")
    public void goToByPawn(int xF, String yF,int xP, String yP )
    {
        int startLetter = 65;
        xF = 8-xF;
        int fyInt = ((int)Character.toUpperCase(yF.charAt(0)) - startLetter);

        xP = 8-xP;
        int pyInt = ((int)Character.toUpperCase(yP.charAt(0)) - startLetter);
        if((fyInt>=0 && fyInt<=8) && (pyInt>=0 && pyInt<=8)) {
            engine.SelectAndMove(
                    xF,
                    Character.toUpperCase(yF.charAt(0)),
                    xP,
                    Character.toUpperCase(yP.charAt(0))
            );
        }
    }

    @Then("White player have turn")
    public void WhitePlayerHaveTurn()
    {
        assertEquals(false, engine.getBoard().getSwitchTurn());
    }

    @Then("Black player have turn")
    public void BlackPlayerHaveTurn()
    {
        assertEquals(true, engine.getBoard().getSwitchTurn());
    }


    ///////////////////
    @When("We save this board to file")
    public void weSaveThisBoardToFile()
    {
        engine.getBoard().saveBoardToFile();
    }

    @When("We load saved board form file")
    public void weLoadSavedBoardFormFile()
    {
        engine.getBoard().loadBoardFromFile("SavedGame.txt");
    }

    @When("We have {int}, {string} on board")
    public void moveTo(int xIn, String name)
    {
        int checkNumber = 0;
        FType type = FType.PAWN;
        if(name.equals("King"))
        {
            type = FType.KING;
        }
        else if(name.equals("Queen"))
        {
            type = FType.QUEEN;
        }
        else if(name.equals("Horse"))
        {
            type = FType.HORSE;
        }
        else if(name.equals("Runner"))
        {
            type = FType.RUNNER;
        }
        else if(name.equals("Tower"))
        {
            type = FType.TOWER;
        }

        Plane boardTable[][] = engine.getBoard().getBoardTable();
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(boardTable[i][j].getFigure() != null)
                {
                    if(boardTable[i][j].getFigure().getType()==type)
                    {
                        checkNumber+=1;
                    }
                }
            }
        }

        if(checkNumber == xIn)
        {
            result *= 1;
        }
        else
        {
            result *= 0;
        }
    }

    @Then("This is true")
    public void thisIsTrue()
    {
        assertEquals(result, 1);
    }

    @Then("This is false")
    public void thisIsFalse()
    {
        assertEquals(result, 0);
    }

}
