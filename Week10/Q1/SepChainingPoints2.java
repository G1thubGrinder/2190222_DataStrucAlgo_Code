public class SepChainingPoints2 extends SepChainingPoints {
	public boolean isCrossRoad(Point p) throws Exception {
		this.add(p);
		return pointValueExist(p);
	}
}
