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
        time = Float.parseFloat(splitCommand[1]);
        
        if(splitCommand.length==2){
            if(splitCommand[0].equals("/ct")){
            
                Timer timer = new Timer(time, 1, 2, () -> this.getServer().broadcastTextMessage("The time's up!"));
                timer.start();
                getServer().broadcastTextMessage("The timer has benn set to " + splitCommand[1]);
            
            }else{
                getServer().broadcastTextMessage("[#FF0000]WRONG PARAMETER");
        
            }
            }else if(splitCommand.length<2){
                event.getPlayer().sendTextMessage("TOO FEW PARAMETERS!");
        
        }else if(splitCommand.length>2){
            event.getPlayer().sendTextMessage("TOO MUCH PARAMETERS!");
        
        }
    }
    
}
