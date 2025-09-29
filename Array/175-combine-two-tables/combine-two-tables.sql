# Write your MySQL query statement below
SELECT firstName ,lastName ,city,state
From Person Left  Join Address
 on Person.personId=Address.personId;