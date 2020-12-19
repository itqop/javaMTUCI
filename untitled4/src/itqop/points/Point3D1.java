package itqop.points;

public class Point3D1 {
    static class Point3D extends point2D{
        private double zCoord;
        public Point3D(double xCoord, double yCoord, double zCoord) {
            super(xCoord,yCoord);
            this.zCoord = zCoord;
        }


        public Point3D() {
            this(0, 0, 0);
        }

        public double getZ() {
            return zCoord;
        }

        public void setZ(double val) {
            zCoord = val;
        }

        public double distanceTo(Point3D p1){
            double r = Math.sqrt(Math.pow(p1.xCoord-this.xCoord,2)+Math.pow(p1.yCoord-this.yCoord,2)+Math.pow(p1.zCoord-this.zCoord,2));
            return r;
        }
    }
    public static boolean equals(Point3D p1, Point3D p2){
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ() ){
            return true;
        }
        return false;
    }
    public static double computeArea(Point3D p1, Point3D p2, Point3D p3){
        double r = 0;
        r = 0.5 * Math.abs(((p1.xCoord-p3.xCoord)*(p2.yCoord-p3.yCoord) - (p1.yCoord-p3.yCoord)*(p2.xCoord-p3.xCoord)));
        return r;
    }

    public static void main(String[] args){

        Point3D pointOne = new Point3D(1,1,2);
        Point3D pointTwo = new Point3D(4,1,-2);
        Point3D default1 = new Point3D();

        System.out.println(equals(pointOne, pointTwo));
        System.out.println(pointOne.distanceTo(pointTwo));
        System.out.println(computeArea(pointOne,pointTwo,default1));

    }
}
