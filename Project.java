/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {
    Scanner reader = new Scanner(System.in);
    private String name;
    private String projectLeader;
    int x;
    public List<Project> pList =new ArrayList<Project>();
    public List<Members> mList;
    public Project(String name, String projectLeader)
    {
        mList = new ArrayList<Members>();
        this.name = name;
        this.projectLeader = projectLeader;
    }
    Project()
    {
        
    }
    void printMenu()
    {
        System.out.println("Press 1 and enter to create a new project.");
        System.out.println("Press 2 and then enter to view all projects by name and index.");
        System.out.println("Press 3 and enter to view a project's attriutes.");
        System.out.println("Press 4 to add team members to a specific project.");
    }
    public Members createMember(String memberName)
    {
        return new Members(memberName);
    }

    public Project createProject(String name, String projectLeader)
    {
        this.name = name;
        this.projectLeader = projectLeader;
        return new Project(name, projectLeader);
    }
    String displayName()
    {
        return name;
    }
    String displayLeader()
    {
        return projectLeader;
    }
    void menuSwitch()
    {
        int x = reader.nextInt();
         switch (x) 
         {
            case 1: System.out.println("Please enter the name of the new project you would like to add.");
                    String name = reader.next();
                    System.out.println("Please enter the name of the project leader.");
                    String projectLeader = reader.next();
                    pList.add(createProject(name,projectLeader));
                    break;
            case 2: for(int i = 0; i < pList.size(); i++)
                {
                    System.out.println(pList.size());
                    System.out.println("Project " + i + "'s project name is " + pList.get(i).displayName() + ", the leader is " + pList.get(i).displayLeader() + ". "
                    );      
                }
                    break;
            case 3: System.out.println("Please enter the index of the project to vew its attributes...");
                    int index1 = reader.nextInt();
                    System.out.println("Project " + index1 + "'s project name is " + pList.get(index1).displayName() + ", the leader is " + pList.get(index1).displayLeader() + ". "
                    );
                    System.out.println("Project " + pList.get(index1).displayName()+ " has ");
                    if(pList.get(index1).mList.size() == 0)
                    {
                        System.out.print("no current team members.");
                    }
                    else
                    {
                        System.out.print(pList.get(index1).mList.size() + " team members and they are...");
                        for(int i = 0; i < pList.get(index1).mList.size(); i++)
                            System.out.println(pList.get(index1).mList.get(i).name);
                    }
                    break;
            case 4: System.out.println("Please enter the project index..");
                    int index2 = reader.nextInt();
                    System.out.println("Please enter the name of team member to add to the project at index " + index2 + ".");
                    String memberName = reader.next();
                    pList.get(index2).mList.add(createMember(memberName));
            default: break;
         }
         continueLoop();
    }
    
    void continueLoop()
    {
        System.out.println("Would you like to continue or end session? Yes to continue or no to end");
        String response = reader.next();
        if(response.equals("yes"))
        {
            printMenu();
            menuSwitch();
        }
        if(response == "no")
        {
            System.out.print("End of test");
        }
        if(response != "yes" || response != "no")
        {
            System.out.print("Invalid Response\n");
            continueLoop();
        }
    }
}
