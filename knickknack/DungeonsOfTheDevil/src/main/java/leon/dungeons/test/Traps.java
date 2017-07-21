package leon.dungeons.test;

import leon.dungeons.model.game.Trap;

//暂时好像只有测试时候用了
public class Traps {

	private Trap[] traps;
	
	public Traps(int num) {
		traps=new Trap[num];
		for(int i=0;i<num;i++) {
			traps[i]=new Trap();
		}
	}

	public Trap[] getTraps() {
		return traps;
	}

}
