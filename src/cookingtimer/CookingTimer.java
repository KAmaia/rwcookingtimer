/*
 * Copyright (c) 2018 migdyn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cookingtimer;


import net.risingworld.api.Plugin;
import net.risingworld.api.Timer;
import net.risingworld.api.events.EventMethod;
import net.risingworld.api.events.Listener;
import net.risingworld.api.events.player.PlayerCommandEvent;

public class CookingTimer extends Plugin implements Listener{

    @Override
    public void onEnable() {
        registerEventListener(this);
    }

    @Override
    public void onDisable() {
        
    }
    
    @EventMethod
    public void onCommand(PlayerCommandEvent event){
        String[] splitCommand;
        float time;
        
        
        splitCommand = event.getCommand().split(" ");
        
        
        if(splitCommand.length==3){
            if(splitCommand[0].equals("/ct") && splitCommand[1].equals("start")){
                time = Float.parseFloat(splitCommand[2]);
                
                //Create a new timer and send a message to the player
                Timer timer = new Timer(new Float(time), 1, 1, () -> event.getPlayer().sendTextMessage("The time's up!"));
                timer.start();
                getServer().broadcastTextMessage("[#0000FF]The timer has been set to " + splitCommand[2]);
            
            }else{
                getServer().broadcastTextMessage("[#FF0000]WRONG PARAMETER!");
        
            }
            }else if(splitCommand.length<3){
                
                if(splitCommand.length==2){
                    
                    if(splitCommand[0].equals("/ct") && splitCommand[1].equals("help")){
                    
                    //Show the list of all commands to the player
                    event.getPlayer().sendTextMessage("[#00FF00]Cooking Timer Commands: \n/ct start <TIME> - Sets the timer to the specified value and starts it. \n/ct help - Displays the list of all commands.");
                    
                    }
                    
                }else if(splitCommand.length<2){
                event.getPlayer().sendTextMessage("[#FF0000]TOO FEW PARAMETERS!");
                }
        }else if(splitCommand.length>3){
            event.getPlayer().sendTextMessage("[#FF0000]TOO MUCH PARAMETERS!");
        
        }
    }
    
}
