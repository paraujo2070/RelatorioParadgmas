#-*- coding: utf8 -*-

''' MYSQL CRUD '''

import psycopg2 as pdb
import warnings
import psycopg2.extras
import sys


# CREATE A NEW TABLE


def createTable(con):
    with con:

        cur = con.cursor()
        cur.execute("DROP TABLE IF EXISTS Emp")
        cur.execute(
            "CREATE TABLE Emp(Id SERIAL PRIMARY KEY, Name VARCHAR(25), Name VARCHAR(25), Nacionalidade VARCHAR(25), DataDeNacimento VARCHAR(25));")
        print 'Employee Table created'

# INSERT VALUES


def insertTable(con):
    with con:

        try:
            cur = con.cursor()

            with warnings.catch_warnings():
                warnings.simplefilter('ignore')
                cur.execute(
                    "CREATE TABLE IF NOT EXISTS Emp(Id SERIAL PRIMARY KEY, Nome VARCHAR(25), Nacionalidade VARCHAR(25), DataDeNascimento VARCHAR(25));")
                print 'Employee Table created'
                warnings.filterwarnings('ignore', 'unknown table')

            Name = raw_input("Enter Name ")
            Nacionalidade = raw_input("Digite a nacionalidade")
            DataDeNascimento = raw_input("Digite a data de nascimento")
            cur.execute("INSERT INTO Emp  (Name, Company_Name, Designation, Age, City) VALUES(%s, %s, %s)",
                        (Name, Nacionalidade, DataDeNacimento))
            print "Record Inserted"
            con.commit()
        except Exception as e:
            print e


# RETRIEVE TABLE ROWS
def retrieveTable(con):
    with con:

        cur = con.cursor(cursor_factory=pdb.extras.DictCursor)
        cur.execute("SELECT * FROM Emp")

        rows = cur.fetchall()
        for row in rows:
            if rows == None:
                print 'Table is Empty'
                break
            else:
                print('ID: {0} Name: {1} Nacionalidade: {2} DataDeNascimento: {3}'.format(
                    row[0], row[1], row[2], row[3]))


# UPDATE ROW
def updateRow(con):
    with con:

        try:
            cur = con.cursor()
            cur = con.cursor(cursor_factory=pdb.extras.DictCursor)
            cur.execute("SELECT * FROM Emp")
            rows = cur.fetchall()
            for row in rows:
                print('ID: {0} Name: {1} Nacionalidade: {2} Data de Nascimento: {3}'.format(
                    row[0], row[1], row[2], row[3]))

            e_id = input("Id do funcionario")
             Name = raw_input("Enter Nome ")
            Nacionalidade = raw_input("Digite a nacionalidade")
            DataDeNascimento = raw_input("Digite a data de nascimento")
            cur.execute("UPDATE Emp SET nome =%s, Nacionalidade = %s, DataDeNascimento = %s, WHERE Id = %s",
                        (nome, Nacionalidade, DataDeNascimento, e_id))

            print "Number of rows updated:",  cur.rowcount
            if cur.rowcount == 0:
                print 'Record Not Updated'
        except TypeError as e:
            print 'ID Not Exist '

#  # DELETE ROW


def deleteRow(con):
    with con:

        try:
            cur = con.cursor()
            cur = con.cursor(cursor_factory=pdb.extras.DictCursor)
            cur.execute("SELECT * FROM Emp")
            rows = cur.fetchall()
            for row in rows:
                print('ID: {0} Name: {1} Nacionalidade: {2} Data de Nascimento: {3}'.format(
                    row[0], row[1], row[2], row[3]))

            id = raw_input("Enter ID for Delete Record")
            cur.execute("DELETE FROM Emp WHERE Id = %s", id)
            print "Number of rows deleted:", cur.rowcount

        except TypeError as e:
            print 'ID Not Exist '
