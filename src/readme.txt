Hibernate, Spring

Naming strategies: CustomNamingStrategy.class
Persistence view: sessionFactory, entityManagerFactory
CREATE DB source using URL:  jdbc:hsqldb:file:~/db/DB: hsqldb_dbdata.txt
and username=sa, password=empty

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

If at least one java run configuration with java props created,
we should create a java app configuration for console, point in "VM options":
--add-modules java.xml.bind

