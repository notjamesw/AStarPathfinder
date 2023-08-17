package code;

import java.util.Vector;

public class Grid{
    private Node[][] grid = new Node[10][10]; //size of grid
    private int Endx, Endy, Startx, Starty;
    private Vector <Node> open = new Vector<Node>();
    private Vector <Node> closed = new Vector<Node>();
    public Grid(int maxObs)
    {
        int x, y, i =0;
        do{
            Endx = (int)(Math.random()*10);
            Endy = (int)(Math.random()*10);
            Startx = (int)(Math.random()*10);
            Startx = (int)(Math.random()*10);
        }while(Endx == Startx && Endy == Starty);
        
        for(x=0; x < 10; x++)
        {
            for(y=0; y < 10; y++)
            {
                grid[x][y] = new Node(distanceToEnd(x, y), x, y);
                if(x == Endx && y == Endy)
                    grid[x][y].setEnd(true);
                else if(x == Startx && y == Starty)
                    grid[x][y].setStart(true);
            }
        }
        do{
        for(x=0; x < 10; x++)
        {
            for(y=0; y < 10; y++)
            {
                if(!grid[x][y].getEnd() && !grid[x][y].getStart() && (int)(Math.random()*(int)(100/maxObs)) == 0 && maxObs > i)
                {
                    grid[x][y].setObstacle(true);
                    i++;
                }
            }
        }
        }while(i < maxObs);
    }

    public void AStarPathFinder()
    {
        grid[Startx][Starty].setdStart(0);
        grid[Startx][Starty].setTotal();
        open.add(grid[Startx][Starty]);
        search();
    }

    public void search()
    {
        int min = 190;
        int xIndex = 0, yIndex = 0;
        if(open.size() < 1)
        {
            System.out.println("error");
            return;
        }
        for(Node i: open)
        {
            if(i.getEnd())
            {
                closed.add(i);
                finish();
                return;
            }
            if(i.getTotal() < min)
            {
                min = i.getTotal();
                xIndex = i.getX();
                yIndex = i.getY();
            }
        }
        closed.add(grid[xIndex][yIndex]);
        grid[xIndex][yIndex].setClosed(true);
        open.remove(grid[xIndex][yIndex]);
        //not setting open to false means else if for open needs to be included after closed in display
        //add to open if the adjacent node is not an obstacle
        try{ 
            if(!grid[xIndex+1][yIndex+1].getObstacle() && !grid[xIndex+1][yIndex+1].getClosed()){
                if(grid[xIndex+1][yIndex+1].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 14 < grid[xIndex+1][yIndex+1].getdStart())
                    {
                        grid[xIndex+1][yIndex+1].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex+1][yIndex+1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                    }
                }
                else{
                    open.add(grid[xIndex+1][yIndex+1]);
                    grid[xIndex+1][yIndex+1].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex+1][yIndex+1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                }
                grid[xIndex+1][yIndex+1].setTotal();
                grid[xIndex+1][yIndex+1].setOpen(true);
            }
        }catch(Exception e){}  
        try{
            if(!grid[xIndex+1][yIndex].getObstacle() && !grid[xIndex+1][yIndex].getClosed()){
                if(grid[xIndex+1][yIndex].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 10 < grid[xIndex+1][yIndex].getdStart())
                    {
                        grid[xIndex+1][yIndex].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex+1][yIndex].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                    }
                }
                else{
                    open.add(grid[xIndex+1][yIndex]);
                    grid[xIndex+1][yIndex].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex+1][yIndex].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                }
                grid[xIndex+1][yIndex].setTotal();
                grid[xIndex+1][yIndex].setOpen(true);
            }
        }catch(Exception e){}
        try{
            if(!grid[xIndex+1][yIndex-1].getObstacle() && !grid[xIndex+1][yIndex-1].getClosed()){
                if(grid[xIndex+1][yIndex-1].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 14 < grid[xIndex+1][yIndex-1].getdStart())
                    {
                        grid[xIndex+1][yIndex-1].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex+1][yIndex-1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                    }
                }
                else{
                    open.add(grid[xIndex+1][yIndex-1]);
                    grid[xIndex+1][yIndex-1].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex+1][yIndex-1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                }
                grid[xIndex+1][yIndex-1].setTotal();
                grid[xIndex+1][yIndex-1].setOpen(true);
            }
        }catch(Exception e){}
        try{
            if(!grid[xIndex][yIndex+1].getObstacle() && !grid[xIndex][yIndex+1].getClosed()){
                if(grid[xIndex][yIndex+1].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 10 < grid[xIndex][yIndex+1].getdStart())
                    {
                        grid[xIndex][yIndex+1].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex][yIndex+1].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                    }
                }
                else{
                    open.add(grid[xIndex][yIndex+1]);
                    grid[xIndex][yIndex+1].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex][yIndex+1].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                }
                grid[xIndex][yIndex+1].setTotal();
                grid[xIndex][yIndex+1].setOpen(true);
            }
        }catch(Exception e){}
        try{
            if(!grid[xIndex][yIndex-1].getObstacle() && !grid[xIndex][yIndex-1].getObstacle()){
                if(grid[xIndex][yIndex-1].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 10 < grid[xIndex][yIndex-1].getdStart())
                    {
                        grid[xIndex][yIndex-1].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex][yIndex-1].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                    }
                }
                else{
                    open.add(grid[xIndex][yIndex-1]);
                    grid[xIndex][yIndex-1].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex][yIndex-1].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                }
                grid[xIndex][yIndex-1].setTotal();
                grid[xIndex][yIndex-1].setOpen(true);
            }
        }catch(Exception e){}
        try{
            if(!grid[xIndex-1][yIndex].getObstacle() && !grid[xIndex-1][yIndex].getClosed()){
                if(grid[xIndex-1][yIndex].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 10 < grid[xIndex-1][yIndex].getdStart())
                    {
                        grid[xIndex-1][yIndex].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex-1][yIndex].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                    }
                }
                else{
                    open.add(grid[xIndex-1][yIndex]);
                    grid[xIndex-1][yIndex].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex-1][yIndex].setdStart(grid[xIndex][yIndex].getdStart() + 10);
                }
                grid[xIndex-1][yIndex].setTotal();
                grid[xIndex-1][yIndex].setOpen(true);
            }
        }catch(Exception e){}
        try{
            if(!grid[xIndex-1][yIndex+1].getObstacle() && !grid[xIndex-1][yIndex+1].getClosed()){
                if(grid[xIndex-1][yIndex+1].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 14 < grid[xIndex-1][yIndex+1].getdStart())
                    {
                        grid[xIndex-1][yIndex+1].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex-1][yIndex+1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                    }
                }
                else{
                    open.add(grid[xIndex-1][yIndex+1]);
                    grid[xIndex-1][yIndex+1].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex-1][yIndex+1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                }
                grid[xIndex-1][yIndex+1].setTotal();
                grid[xIndex-1][yIndex+1].setOpen(true);
            }
        }catch(Exception e){}
        try{
            if(!grid[xIndex-1][yIndex-1].getObstacle() && !grid[xIndex-1][yIndex-1].getClosed()){
                if(grid[xIndex-1][yIndex-1].getOpen())
                {
                    if(grid[xIndex][yIndex].getdStart() + 14 < grid[xIndex-1][yIndex-1].getdStart())
                    {
                        grid[xIndex-1][yIndex-1].setPrev(grid[xIndex][yIndex]);
                        grid[xIndex-1][yIndex-1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                    }
                }
                else{
                    open.add(grid[xIndex-1][yIndex-1]);
                    grid[xIndex-1][yIndex-1].setPrev(grid[xIndex][yIndex]);
                    grid[xIndex-1][yIndex-1].setdStart(grid[xIndex][yIndex].getdStart() + 14);
                }
                grid[xIndex-1][yIndex-1].setTotal();
                grid[xIndex-1][yIndex-1].setOpen(true);
            }
        }catch(Exception e){}
        display();
        search();
    }
    public void finish()
    {
        int x = Endx, y = Endy;
        int temp;
        while(x != Startx && y != Starty)
        {
            temp = x;
            x = grid[x][y].getPrev().getX();
            y = grid[temp][y].getPrev().getY();
            grid[x][y].setPath(true);
        }
        display();
    }

    public void display()
    {
        int x, y;
        System.out.println("start (blue): " + Startx + " " + Starty);
        System.out.println("end (purple): " + Endx + " " + Endy);
        for(x=0; x < 10; x++)
        {
            for(y=0; y < 10; y++)
            {
                if(grid[x][y].getStart() || grid[x][y].getPath()) //start
                {
                    //System.out.print("S ");
                    System.out.print("\u001B[44m  \u001B[34m");
                }
                else if(grid[x][y].getEnd()) //end
                {
                    //System.out.print("E ");
                    System.out.print("\u001B[45m  \u001B[35m");
                }
                else if(grid[x][y].getObstacle())
                {
                    //System.out.print("X ");
                    System.out.print("\u001B[46m  \u001B[36m");
                }
                else if(grid[x][y].getClosed() && !grid[x][y].getPath())
                {
                    //System.out.print("C ");
                    System.out.print("\u001B[41m  \u001B[31m");
                }
                else if(grid[x][y].getOpen())
                {
                    //System.out.print("O ");
                    System.out.print("\u001B[42m  \u001B[32m");
                }
                else
                    //System.out.print("N ");
                    System.out.print("\u001B[47m  \u001B[37m");
            }
            System.out.println("\u001B[0m");
        }
        //System.out.println("\u001B[0m");
    }
    public int distanceToEnd(int x, int y){
        int d = 0, xDistance, yDistance;
        xDistance = Math.abs(x-Endx);
        yDistance = Math.abs(y-Endy);
        if(xDistance > yDistance)
        {
            d += 14*yDistance + 10*(xDistance-yDistance);
        }
        else if(yDistance > xDistance)
        {
            d += 14*xDistance + 10*(yDistance-xDistance);
        }
        else
            d += 14*xDistance;
        return d;
    }
}