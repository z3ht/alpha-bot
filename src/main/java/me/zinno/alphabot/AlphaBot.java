package me.zinno.alphabot;

import me.zinno.alphabot.bot.StateBot;
import me.zinno.alphabot.data.node.SampleDataNode;
import me.zinno.alphabot.delegator.ManipulatableDelegator;
import me.zinno.alphabot.manipulatable.state.aatba.Aatba;
import me.zinno.alphabot.util.PortReader;
import rlbot.Bot;
import rlbot.ControllerState;
import rlbot.flat.GameTickPacket;
import rlbot.manager.BotManager;
import rlbot.pyinterop.DefaultPythonInterface;
import rlbot.pyinterop.PythonInterface;
import rlbot.pyinterop.PythonServer;

import java.util.Arrays;

public class AlphaBot extends StateBot<SampleDataNode> {

    public AlphaBot(int playerIndex) {
        super(
                new ManipulatableDelegator<>(
                        Arrays.asList(
                                new Aatba()
                        )
                ),
                new Data<SampleDataNode<? extends ControllerState>>(
                        new ManipulatableDelegator<>(
                                Arrays.asList(

                                )
                        ),
                        playerIndex
                ) {
                    @Override
                    public SampleDataNode createNode(GameTickPacket packet, int playerIndex) {
                        CarData[] carData = new CarData[packet.playersLength()];
                        for(int i = 0; i < carData.length; i++) {
                            carData[i] = new CarData(i);
                        }
                        return new SampleDataNode(carData, new BallData(), new BoostData(), playerIndex);
                    }
                },
                playerIndex
        );
    }

    @Override
    public void retire() {
        System.out.println(String.format("Retiring AlphaBot[%d]", super.getIndex()));
    }

    public static void main(String[] args) {
        PythonInterface pythonInterface = new DefaultPythonInterface(new BotManager()) {
            @Override
            protected Bot initBot(int index, String botType, int team) {
                return new AlphaBot(index);
            }
        };
        Integer port = PortReader.readPortFromFile("port.cfg");
        new PythonServer(pythonInterface, port).start();
    }

}
