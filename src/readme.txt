Hibernate, Spring

Naming strategies: CustomNamingStrategy.class
Persistence view: sessionFactory, entityManagerFactory
CREATE DB source: dbdata.txt

TESTING:

HibernateConsole:
1. Choose sessionFactory in Persistence view
2. Set: DB source, NamingStrategy
3. Run in console: "select a from Naming a"

JPAConsole:
1. Choose entityManagerFactory in Persistence view
2. Set: DB source
3. Run in console: "select a from Naming a"

Check Hibernate Console from JPA unit.


