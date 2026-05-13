import java.io.*;
import java.util.*;

class Student_details_update
{
	public static void main(String arg[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do
		{	
			try 
			{
				System.out.println("\n1. Add Student\n2. Display\n3. Search\n4. Modify\n5. Delete\n6. Exit");
				System.out.print("Enter choice: ");
				
				choice = sc.nextInt();
				switch(choice)
				{
					case 1:
						addStudent();
						break;
					case 2:
						disStudent();
						break;
					case 3:
						searchStudent();
						break;
					case 4:
						modifyStudent();
						break;
					case 5:
						deleteStudent();
						break;
					case 6:
						System.out.println("Exiting....");
						break;
					default:
						System.out.println("Invalid choice");
				}
			}catch(InputMismatchException e)
			{
				System.out.println("Enter above choices only");
				sc.next();  //for clearing exception alphabets instead of choice
			}
			
		}while(choice!=6);
			
	}
	
	static void addStudent() throws IOException
	{
		try {
			File file = new File("student1.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter br = new BufferedWriter(fw);
			
			int roll, sem, m1, m2, m3, total;
			float per;
			String name, branch;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter student roll, name, sem, branch, marks1, marks2, marks3: ");
			
			roll = sc.nextInt();
			name = sc.next();
			sem = sc.nextInt();
			branch = sc.next();
			m1 = sc.nextInt();
			m2 = sc.nextInt();
			m3 = sc.nextInt();
			
			total = (m1+m2+m3);	
			per = (m1+m2+m3)/3.0f;
			
			br.write(roll+" "+name+" "+sem+" "+branch+" "+m1+" "+m2+" "+m3+" "+total+" "+per+"\n");
			System.out.println("Student detailes added successfully.....");
			br.close();
		}catch(IOException e) 
		{
			System.out.println(e);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter correct values as above mentioned");
		}
	}
		
	static void disStudent() throws IOException
	{
		try {
			File file = new File("student1.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String str;
			
			while((str = br.readLine()) != null)
			{
				System.out.println(str);
			}
			br.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	static void searchStudent() throws IOException
	{
		
		try {	
		File file = new File("student1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str;
		System.out.println("Enter Roll number to search: ");
		Scanner sc = new Scanner(System.in);

			int rn = sc.nextInt();
			boolean found = false;
			
			while((str = br.readLine()) != null)
			{
				String s[] = str.split(" "); 
				if(Integer.parseInt(s[0]) == rn)
				{
					System.out.println(str+" ");
					found = true;
					break;
				}
			}
		
		br.close();
		
		if(!found)
			System.out.println("Student details not found");
		}catch(IOException e)
		{
			System.out.println(e);
		}catch(InputMismatchException e)
		{
			System.out.println("Enter Numbers only");
		}
	}
	
	static void modifyStudent() throws IOException
	{
		try {
		//File file = new File("student1.txt");
		//BufferedReader br = new BufferedReader(new FileReader(file));
	
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
			try 
			{
				System.out.println("\n1. Sem\n2. Branch\n3. Marks");
				System.out.print("Enter choice: ");
				
				choice = sc.nextInt();
				switch(choice)
				{
					case 1:
						semester();
						break;
					case 2:
						modifyBranch();
						break;
					case 3:
						modifyMarks();
						break;
					default:
						System.out.println("Invalid choice");
				}
			}catch(InputMismatchException e)
			{
				System.out.println("Enter above choices only");
				sc.next();  //for clearing exception alphabets instead of choice
			}
	
		}catch(IOException e)
		{
			System.out.println(e);
		}catch(InputMismatchException e)
		{
			System.out.println("Enter Numbers only");
		}
	}
	
	static void deleteStudent() throws IOException
	{
		File file = new File("student1.txt");
		File tempfile = new File("temp.txt");
		boolean found = false;
		
			try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempfile));
			
			String str;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter roll number to Delete: ");
			int r = sc.nextInt();

			
			while((str = br.readLine()) != null)
			{
				String s[] = str.split(" "); 
				if(Integer.parseInt(s[0]) == r)
				{
					System.out.println("Deleted student details is: ");
					System.out.println(str+" ");
					found = true;
				}
				else {
					bw.write(str+"\n");
				}
			}
				
			bw.close();
			br.close();
			
			}catch(IOException e)
			{
				System.out.println(e);
			}catch(InputMismatchException e)
			{
				System.out.println("Enter Numbers only");
			}
		
		if(found) {
			file.delete();
			tempfile.renameTo(file);
		}
		else {
			System.out.println("Student not found");
			tempfile.delete();
		}
	
	}
	
	static void semester() throws IOException
	{
		File file = new File("student1.txt");
		File tempfile = new File("temp.txt");
		boolean found = false;
		
			try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempfile));
			
			int sem;
			String str;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter roll number to Modify: ");
			
			int r = sc.nextInt();
			//boolean found = false;
			
			while((str = br.readLine()) != null)
			{
				String s[] = str.split(" "); 
					
				if(Integer.parseInt(s[0]) == r)
				{
					System.out.println(str+" ");
					
					System.out.println("Enter semester of student");
					
					sem = sc.nextInt();
					System.out.println(s[0]+" "+s[1]+" "+sem+" "+s[3]+" "+s[4]+" "+s[5]+" "+s[6]+" "+s[7]+" "+s[8]+"\n");
					bw.write(s[0]+" "+s[1]+" "+sem+" "+s[3]+" "+s[4]+" "+s[5]+" "+s[6]+" "+s[7]+" "+s[8]+"\n");
					System.out.println("Student detailes modified successfully.....");
					found = true;
				}
				else {
					bw.write(str+"\n");
				}
			}
			br.close();
			bw.close();
		
			}catch(IOException e)
			{
				System.out.println(e);
			}catch(InputMismatchException e)
			{
				System.out.println("Enter Numbers only");
			}
		
		if(found) {
			file.delete();
			tempfile.renameTo(file);
		}
		else {
			System.out.println("Student not found");
			tempfile.delete();
		}
	}
	static void modifyBranch() throws IOException
	{
		File file = new File("student1.txt");
		File tempfile = new File("temp.txt");
		boolean found = false;
		
			try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempfile));
			
			String str, branch;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter roll number to Modify: ");
			
			int r = sc.nextInt();
			
			while((str = br.readLine()) != null)
			{
				String s[] = str.split(" "); 
					
				if(Integer.parseInt(s[0]) == r)
				{
					System.out.println(str+" ");
					
					System.out.println("Enter Branch of student");
					
					branch = sc.next();
					System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+branch+" "+s[4]+" "+s[5]+" "+s[6]+" "+s[7]+" "+s[8]+"\n");
					bw.write(s[0]+" "+s[1]+" "+s[2]+" "+branch+" "+s[4]+" "+s[5]+" "+s[6]+" "+s[7]+" "+s[8]+"\n");
					System.out.println("Student detailes modified successfully.....");
					found = true;
				}
				else {
					bw.write(str+"\n");
				}
			}
			bw.close();
			br.close();
			
			}catch(IOException e)
			{
				System.out.println(e);
			}catch(InputMismatchException e)
			{
				System.out.println("Enter Numbers only");
			}
		
		if(found)
        {
            file.delete();
            tempfile.renameTo(file);
        }
        else
        {
            System.out.println("Student not found.");
            tempfile.delete();
        }
	}
	
	static void modifyMarks() throws IOException
	{
		File file = new File("student1.txt");
		File tempfile = new File("temp.txt");
		boolean found = false;
		
			try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempfile));
			
			int m1, m2, m3, total;
			float per;
			String str;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter roll number to Modify: ");
			
			int r = sc.nextInt();
			//boolean found = false;
			
			while((str = br.readLine()) != null)
			{
				String s[] = str.split(" "); 
					
				if(Integer.parseInt(s[0]) == r)
				{
					System.out.println(str+" ");
					
					System.out.println("Enter marks1, marks2, marks3 of student");
					m1 = sc.nextInt();
					m2 = sc.nextInt();
					m3 = sc.nextInt();
					
					total = (m1+m2+m3);	
					per = (m1+m2+m3)/3.0f;
					
					System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+m1+" "+m2+" "+m3+" "+total+" "+per+"\n");
					bw.write(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+m1+" "+m2+" "+m3+" "+total+" "+per+"\n");
					System.out.println("Student detailes modified successfully.....");
					found = true;
				}
				else {
					bw.write(str+"\n");
					//System.out.println("wwwwwwww");
				}
			}
			//System.out.println("ssssssss");
			br.close();
			bw.close();
			
			}catch(IOException e)
			{
				System.out.println(e);
			}catch(InputMismatchException e)
			{
				System.out.println("Enter Numbers only");
			}
		if(found)
        {
			file.delete();
            tempfile.renameTo(file);
        }
        else
        {
            System.out.println("Student not found.");
            tempfile.delete();
        }
	}
}	