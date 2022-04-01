
# we will take data from the drive so we must mount it 
from google.colab import drive
import os

import csv
import matplotlib.pyplot as plt

drive.mount('/content/gdrive')

def checkTheString(givenString):
    for string in ['compile',"provided","runtime","test","managed","meaningful","seperable"]:
        givenString=givenString.lower()
        theString=givenString[0:len(string)]
        if(theString==string):
            return theString
    return givenString.lower()

path = "/content/gdrive/MyDrive/MVREnch"
List=[]
for filename in os.listdir(path):
    # make a full path
    thePath=path+"/"+filename
    if filename[len(filename)-4:]!=".csv":
            continue
    # open image
    with open(thePath) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        ourData={}
        count=-1
        for row in csv_reader:
            count+=1
            # to avoid the headlines
            if count == 0 :
                continue

            count2=0
            # for everything in the row
            for i in row:
                count2+=1
                if count2==1:
                    continue
                # if it is x do not count it
                if checkTheString(i)=="x":
                    continue

                
                if checkTheString(i) not in ourData:
                    ourData[checkTheString(i)]=1
                else:
                    ourData[checkTheString(i)]=ourData[checkTheString(i)]+1

        for i in ourData.keys():
            ourData[i]/=2


        fig, ax=plt.subplots(figsize=(15,15))
        graph=ax.bar(ourData.keys(),ourData.values())
        
        # rotate the labels and make the title
        ax.set_xticklabels(ourData.keys(), rotation=45)
        ax.set_title("File: "+filename)

        # put the percentage 
        i = 0
        for p in graph:
            width = p.get_width()
            height = p.get_height()
            x, y = p.get_xy()
            i+=1
        
        plt.show()