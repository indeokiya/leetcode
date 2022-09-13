# Write your MySQL query statement below

select customer_number
from Orders
group by customer_number
having count(customer_number) >= all (
    select count(customer_number)
    from Orders
    group by customer_number
)
