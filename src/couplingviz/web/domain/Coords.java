package couplingviz.web.domain;

import org.springframework.stereotype.Component;

/**
 *  A POJO class annotated as a component and represents the coordinate points of 
 *  of a class or an interface in a source code.
 * @version 1.0, April 2017
 */
@Component
public class Coords {
	
		private int x;
		private int y;
		
		public Coords(){
			
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}

}
