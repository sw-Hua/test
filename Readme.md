***\*1.Project introduction\****

This project is a catering software product, including the system management background and client application (not yet realized) two parts, including user management function, classification function, dish function, set menu function, order management function, shopping cart function, VIP function, points function, payment function, takeaway function. Done by the group leader Jingsong Pang, and the group members Songweng Hua, Yongyan Liu, Shao Yin and Xuhao Guo.

***\*2.\*******\*Function details\****

| F101 | Customer and Employee Management | The administrator can add, delete, update and query customers, display them in pages according to the query criteria, besides,he can disable or edit the corresponding selected users.Cache technology is used to store user information in the database for sign in. Customers can log in with the verification code. | Xuhao Guo     |
| ---- | -------------------------------- | ------------------------------------------------------------ | ------------- |
| F102 | Category management              | The administrator can create new dish set categories and dish categories, and sort the order of display. On the administrator page, the administrator can add, delete, update and query categories showing them by pages, besides sort the categories with ascending and descending symbols. | Xuhao Guo     |
| F103 | Dish management                  | Employees can modify, add, delete, sort, search for product information and inventory, and choose to stop or sell products. Customers can only search and view the specific information of the dishes, and at the same time, they can view the search history and add the dishes that need to be ordered to the shopping cart | Yongyan Liu   |
| F104 | Dish Set management              | Employees can modify, add, delete, sort, search, set package information and inventory according to menu modifications, choose to stop selling or sell products. Customers can only search and view the specific information of the dishes. At the same time, they can view the search history and add the dishes that need to be ordered to the shopping cart | Yongyan Liu   |
| F105 | Order management                 | Users are able to place the order and check order history, and cancel the order they have placed. Staff can view all orders that are placed into the system and can search by Order number and user ID, and be able to manage the order. | Jingsong Pang |
| F106 | ShoppingCart management          | Users can add or delete multiple dishes into the chart, and can see the total price, name of the dish, number of the dish and name of the store. | Jingsong Pang |
| F107 | Payment Management               | Users can choose their way to do the purchase, and they can use coupon to get a discount. And also users can cancel the purchase if they don’t want to order anymore. | Ying Shao     |
| F108 | Delivery Management              | Users can edit their collection location to pick their meal, and they can enter their basic personal information so that the delivery driver can contact with them. Also, users can select the delivery time, they can get their meals according to their personal schedule. | Ying Shao     |
| F109 | VIP Management                   | Users can purchase VIP status by purchasing a paid membership. There are various types of membership available at different price points including, hidden menu services, and priority restaurant reservations. At the same time, the restaurant also offers a wide range of additional services, gifts and events for all VIP customers. | Songwen Hua   |
| F110 | Rewards System Management        | Users can register for membership and are automatically provided with a member ID. Users will receive a voucher on their first registration and will receive points for each subsequent purchase, which can be redeemed for vouchers. You can use the coupons when you make a purchase. | Songwen Hua   |

 

**3.** ***\*Implementation technology\****

1). The user layer

In this project, we will use H5, Vue.js, ElementUI and other technologies when building the front-end page of the system management background.

 

2). The application layer

SpringBoot: Quickly build Spring projects, using the idea of "convention over configuration" to simplify the configuration of Spring projects.

Spring: Centrally manages the various resources (beans) in a project, which are used in all layers of Web development.

SpringMVC: SpringMVC is a module of the Spring framework. SpringMVC and Spring can be seamlessly integrated without the need for an intermediate integration layer.

SpringSession: addresses Session sharing in a clustered environment.

Lombok: Can simplify Java code in the form of simple annotations, improve the development efficiency of developers. For example, Javabeans that often need to be written in development will take time to add the appropriate getter/setter, and perhaps also to write the constructor, equals, etc.

Swagger: Helps developers automatically document and test interfaces.

 

3)The data layer

MySQL: relational database. The core business data of this project will be stored by MySQL.

MybatisPlus: This project persistence layer will use MybatisPlus to simplify the development, the basic single table add, delete, change and check directly call the method provided by the frame.

Redis: an in-memory database stored in key-value format with high access speed. It is often used as a cache (to reduce database access pressure and provide access efficiency) and will be used in future performance optimization.

 

4) Tools

Git: A version control tool that is used to manage code in a project during team work.

Maven: Project building tool.

Junit: unit test tool. After functions are implemented, developers need to use junit to unit test functions.