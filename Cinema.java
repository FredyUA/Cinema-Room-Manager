package cinema;

import java.util.Scanner;

public class Cinema {
	
	String[][] sits;
	int cost;
	int income = 0;
	int tickets = 0;
	int col_sits = 0;
	

	public static void main(String[] args) {
		
		
		Cinema cinema = new Cinema();
		cinema.initial();

	}
	
	public void printField () {
		
		System.out.println("Cinema:");
		System.out.print("  ");
		for (int i = 0; i < this.sits[0].length; i++) {
			System.out.print((i+1) + " ");
		}
		System.out.println();		
		for (int i = 0; i < this.sits.length; i++) {
			System.out.print((i+1) + " ");
			for (int j = 0; j < this.sits[i].length; j++) {
				System.out.print(this.sits[i][j] + " ");
			}
			System.out.println();
		}
				
	}
	
	public void initial() {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of rows:");
		System.out.print("> ");
		int amountRows = scanner.nextInt();
		System.out.println("Enter the number of seats in each row:");
		System.out.print("> ");
		int amountSit = scanner.nextInt();
		
		this.sits = new String[amountRows][amountSit];
		
		for (int i = 0; i < this.sits.length; i++) {
			for (int j = 0; j < this.sits[i].length; j++) {
				this.sits[i][j] = "S";
			}
		}
		
		this.col_sits = amountRows * amountSit;
		
		System.out.println();
		
		while(true) {
			
			System.out.println("1. Show the seats");
			System.out.println("2. Buy a ticket");
			System.out.println("3. Statistics");
			System.out.println("0. Exit");
			System.out.print("> ");
			
			int number = scanner.nextInt();
			
			switch (number) {
			case 0:
				return;
			case 1:
				System.out.println();
				printField();
				System.out.println();
				break;
			case 2:
				while(true) {
					System.out.println();
					
					System.out.println("Enter a row number:");
					System.out.print("> ");
					int row = scanner.nextInt();
					System.out.println("Enter a seat number in that row:");
					System.out.print("> ");
					int sit = scanner.nextInt();
					System.out.println();
					
					if (row > sits.length || sit > sits[0].length) {
						System.out.println("Wrong input!");
						continue;						
					}
					
					if (this.sits[row-1][sit-1] == "B") {
						System.out.println("That ticket has already been purchased!");
						continue;
					}
					
					
						
					
					this.sits[row-1][sit-1] = "B";
					this.tickets++;
					
					System.out.print("Ticket price: ");
					
					if (amountRows * amountSit > 60) {
						int rows1 = amountRows / 2;			
						if (row <= rows1) {
							System.out.println("$10");
							this.income += 10;
						} else {
							System.out.println("$8");
							this.income += 8;
						}
					} else {
						System.out.println("$10");
						this.income += 10;
					}
					
					System.out.println();
					break;
				}
				break;				
			case 3:
				System.out.println();
				System.out.println("Number of purchased tickets: " + this.tickets);
				double perc = (double)this.tickets / this.col_sits * 100;
				System.out.printf("Percentage: %.2f", perc);
				System.out.println("%");
				System.out.println("Current income: $" + this.income);
				
				
				
				if (amountRows * amountSit > 60) {
					int rows1 = amountRows / 2;
					int rows2 = amountRows - rows1;
					System.out.println("Total income: $" + ((rows1 * amountSit * 10) + (rows2 * amountSit * 8)));
					
				} else {
					System.out.println("Total income: $" + amountRows * amountSit * 10);
				}
				System.out.println();
				
				
				
				
				
			}
			
		}		
	}

}
