/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {

	public static int calculateWaitTime( ArrayDeque<Integer> ticketsQueue, int position ) {
		int timeElapsed = 0; 
		int friendPos = position;
		boolean notDone = true;
		
		while(notDone){
			int tixNeededByFirst =  ticketsQueue.remove();
			if(friendPos == 0 && tixNeededByFirst == 1) {
				timeElapsed++;
				return timeElapsed;
			}
			else if(friendPos == 0) {
				friendPos = ticketsQueue.size();
				timeElapsed++;
				
				ticketsQueue.add(--tixNeededByFirst);
			}
			else if(tixNeededByFirst == 1) {
				timeElapsed++;
				friendPos--;
			}
			else if(tixNeededByFirst >1) {
				timeElapsed++;
				ticketsQueue.add(--tixNeededByFirst);
				friendPos--;
			}
			
		}
		return timeElapsed;
	}
}

/*
 
  while(notDone){
  
  	remove front of queue save it into a variable X
  	if friendPosition is 0, and X is 1,
  			then add one to time and return
  	
  	if friendPosition is 0
  	 		set friendPosition to end of queue index (?) .. size 
  	 		add one to time
  	 		put X-1 to back of Q
  	else if X is 1
  			add one to time
  			friendPosition --
   	else if X is > 1
   			add one to time
   			put X-1 to back of Q
   			friendPosition --
   	
  
  
  
  
  
  }
  
  
  
  
 */
