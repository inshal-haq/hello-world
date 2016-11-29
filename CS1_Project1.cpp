//Project  for CS1337.003
//Programmer: Inshal Haq
//NetID: iuh150030
//Description of program: Reads a matrix of numbers from a file inputted by the user 
//and determines if the matrix exhibits vertical additive symmetry 

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

//constant variable for arrays
const int ARRAY_SIZE = 20;

//function prototypes
void Calculate_Column_Sums(double[][ARRAY_SIZE], int, int);
void Determine_Symmetry(double [], int, int);

int main()
{
   // variables used
   int Rows, Columns;
   string filename;
   ifstream inputFile;
   double values[ARRAY_SIZE][ARRAY_SIZE];

   // prompt user for filename
   cout << "Enter the name of the file: ";
   getline(cin,filename);

   //open file
   inputFile.open(filename.c_str());

   // if statement for invalid file
   if (inputFile.fail())
   {
      cout << "file failed to read\n";
   }
   else
   {
      // if statements to check if Rows and Columns are integer values, if not then display error message and exit program  
      if (inputFile >> Rows)
      {
         if (inputFile >> Columns)
         {
            // if statement to not allow more than 20 Rows or Columns
            if (Rows > 20 || Columns > 20)
            {
               cout << "Rows and Columns must be less than or equal to 20";
               system("pause");
               return 0;
            }

            else
            {
               // nested for loops to read and assign values in file to a 2-dimensional array
               for (int row = 0; row < Rows; ++row)
                  for (int column = 0; column < Columns; ++column)
                     // if statement to check if the values in the file's matrix are numbers, if not then display error message and exit program  
                     if (!(inputFile >> values[row][column]))
                     {
                        cout << "Error: Matrix must contain only numbers\n";
                        system("pause");
                        return 0;
                     }
               
               // call Calculate_Column_Sums function
               Calculate_Column_Sums(values, Rows, Columns);
            }
         }
         else
            cout << "Error: Matrix must contain only numbers\n";
      }
      else
         cout << "Error: Matrix must contain only numbers\n";
   }
   system("pause");
   return 0;
}

void Calculate_Column_Sums(double values[][ARRAY_SIZE], int Rows, int Columns)
{
   // array to hold the file's matrix column sums
   double Sums_Holder[ARRAY_SIZE] = { 0 };
   
   // nested for loop to calculate sum of columns and assign them to an array
   for (int column = 0; column < Columns; ++column)
      for (int row = 0; row < Rows; ++row)
         Sums_Holder[column] += values[row][column];
   
   // call  Determine_Symmetry function
   Determine_Symmetry(Sums_Holder, Rows, Columns);
   return;
}

void Determine_Symmetry(double Sums_Holder[], int Rows, int Columns)
{
   // for loop that determines the vertical additive symmetry of the matrix
   for (int count = 0; count < Columns; ++count)
   {
      // if statement that determines if the column sums equal each other, if not then displays no vertical additive symmetry
      if (Sums_Holder[count] == Sums_Holder[Columns - count - 1])
      {
         // determines if number of Columns is positive or negative
         if (Columns % 2 == 0)
         {
            // if statement that displays vertical additive symmetry if number of Columns is even
            if (count == Columns - count)
               cout << "vertical additive symmetry\n";
         }
         else
            // if statement that displays vertical additive symmetry if number of Columns is odd
            if (count == Columns - count - 1)
               cout << "vertical additive symmetry\n";
      }
      else
      {
         cout << "no vertical additive symmetry\n";
                  return;
      }
   }
   return;
}