# Write your MySQL query statement below

select min(abs(p.x-q.x)) as shortest
from point as p
join point as q on (p.x <> q.x)
