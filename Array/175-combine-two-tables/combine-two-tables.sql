# Write your MySQL query statement below
SELECT firstName ,lastName ,city,state
From Person as a Left  Join Address as p
 on p.personId=a.personId;