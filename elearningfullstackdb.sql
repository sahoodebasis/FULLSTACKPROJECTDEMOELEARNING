create database elearning;
use elearning;
drop database elearning;

insert into user (userid,contactNo,dateOfBirth,email,hasSubscribed,isActive,name,password,role) values 
(1,'9382829908','1998-12-02','srikant@gmail.com',true,true,'Srikant','abcde@123','user'),
(2,'9839903899','1990-02-04','yash@gmail.com',true,true,'Yash','abcde@123','user'),
(3,'9987328978','1999-10-16','akshay@gmail.com',true,true,'Akshay','abcde@123','user'),
(4,'9892770082','1997-11-22','charan@gmail.com',false,true,'Charan','abcde@123','user'),
(5,'9783289928','1998-12-19','chaitra@gmail.com',false,true,'Chaitra','abcde@123','user'),
(6,'9829729293','1991-02-28','daksh@gmail.com',false,true,'Daksh','abcde@123','user'),
(7,'9998821312','1995-04-21','sandeep@gmail.com',false,true,'Sandeep','abcde@123','vendor'),
(8,'9998289534','1989-10-19','rahul@gmail.com',false,true,'Rahul','abcde@123','vendor'),
(9,'9956283790','1996-11-20','suresh@gmail.com',false,true,'Suresh','abcde@123','vendor'),
(10,'9967377872','2000-04-22','abdul@gmail.com',false,true,'Abdul','abcde@123','vendor'),
(11,'8723898738','2001-03-22','amitlal@gmail.com',false,true,'Amit Chowdhary','abcde@123','admin');


insert into services(serviceId,serviceName,isActive) values
(1,"Online Training",true),
(2,"Offline Training",true),
(3,"Downloadable Materials",true),
(4,"Webinar",true);

insert into notification_table(notification_Id,user_id,description) values
(1,1,"New Courses Added Recently. Check it out."),
(2,2,"New Courses Added Recently. Check it out."),
(3,3,"New Courses Added Recently. Check it out.");


insert into courses_table (course_id,course_category,course_name,short_description,vendor_id,is_active,price,duration,date_of_launch,picture,languages,learning_goals,requirements,course_description,author,serviceId)values

(1,'instructor-led','Machine Learning','ML is taught here',7,true,1000,190,'2020-04-22','https://img-a.udemycdn.com/course/240x135/950390_270f_3.jpg?Ngx0j5pUkVGKSW7AnGPdSfZipEhp4j4G2mJjV_hJNQXcWgNnrAFGAdkHgjJFdXocpG8UNhQ33nmT5fQEQoIeDZyEBJldLqPjN4T4VLZPK-coPh_gNK7UW5K0awCN
 ','English, French','Logistic Regression,Artificial Neural Network,Machine Learning (ML) Algorithms,Machine Learning','Basics of python',
 'This course provides a broad introduction to machine learning, datamining, and statistical pattern recognition. 
Topics include: (i) Supervised learning (parametric/non-parametric algorithms, support vector machines, kernels, neural networks).
 (ii) Unsupervised learning (clustering, dimensionality reduction, recommender systems, deep learning). (iii) Best practices in machine learning (bias/variance theory; innovation process in machine learning and AI).','Sandeep',1),

(2,'instructor-led','Java Core and Advanced','Java is taught here',7,true,2600,90,'2020-02-21','https://img-a.udemycdn.com/course/240x135/827692_91ad_2.jpg?h4AzideQHNoIbXXZ_mGxC87PuEOQpsefj9Zy50tJyyJbMJPwut690TSbUHSVLn6IIgxEo7s0wT5sWYwKx1ETwoenNPD3_07_HR_-hTQqh7w-Hkan4jLK_L4ag_MN
','English, French','Java Programming,Problem Solving,Programming Principles','Basics of Oops','In this course, students will learn fundamental Java and other real-time examples.
 The focus will be on learning about java, oops concepts, and best practices that can be immediately implemented in real-time.Designed for beginners, this Specialization will teach you core programming concepts and equip you to write programs to solve complex problems. In addition,
 you will gain the foundational skills a software engineer needs to solve real-world problems, from designing algorithms to testing and debugging your programs.','Kishore',1),

(3,'instructor-led','Artificial Intelligence','AI is taught here',7,true,1600,90,'2021-01-22','https://img-b.udemycdn.com/course/240x135/1219332_bdd7.jpg?secure=_P-Vp_uOKwZsRTRJ0Ldecw%3D%3D%2C1614496107',
'English, French','Workflow of Machine Learning projects,AI terminology,AI strategy,Workflow of Data Science projects','Real time use of AI','In this course, students will learn fundamental artificial intelligence techniques that can be used 
to make sense of real life use cases.The meaning behind common AI terminology, including neural networks, machine learning, deep learning, and data science,What AI realistically can--and cannot--do?How to spot opportunities to apply AI to problems in your own organization?How to work with an AI team and build an AI strategy in your company?','Ravinder',1),

(4,'instructor-led','C and C++','C++ is taught here',8,true,1200,70,'2021-02-12','https://img-b.udemycdn.com/course/240x135/1576854_9aeb_2.jpg?secure=CaiAFl5JQoFBvF1t-h34cw%3D%3D%2C1614496244','English, French','C and C++','Basics of C++','Learn C++ fundamentals
 with hands-on exercises.Create highly efficient compiled code that runs with minimal overhead.This Specialization is intended for all programming enthusiasts, as well as beginners, computer and other scientists, and artificial intelligence enthusiasts seeking to develop their programming skills in the foundational languages of C and C++.','Abhishek',1),

(5,'self-learning','Robotics','Robotics is taught here',8,false,1800,90,'2019-05-10','https://img-a.udemycdn.com/course/240x135/2580536_b493.jpg?dLu06nB3tSrH5OIobEhhLSZpZXhWqosOhBFV3TBbCbQwpC6plz8WxFBsKO5o9a4ITExK9SuI9HI4TEjflolIxXvJZ7jtwIWFDm6OVxGOUS6OQB9M4KrSjD9CGVQ
','English, French','Motion Planning,Particle Filter,Matlab,Robotics,Quadcoper,Automated Planning And Scheduling',
'Basics of Programming Languages','Learn Robotics fundamentals with hands-on exercises.The Introduction to Robotics Specialization introduces you to the concepts of robot flight and movement, how robots perceive their environment, and how they adjust their movements to avoid obstacles, navigate difficult terrains and accomplish complex tasks such as construction and disaster recovery.Create highly efficient compiled code that runs with minimal overhead.','Siri Sai',1),

(6,'self-learning','Data Science','DS is taught here',8,true,900,120,'2019-06-08','https://img-b.udemycdn.com/course/240x135/1754098_e0df_3.jpg?secure=L-47DCsluRKp7ZFEhzV3mg%3D%3D%2C1614496359','English, French','R Programming,Regression Analysis,Data Science,Rstudio,Data Analysis,Debugging,Data Manipulation','Basics of python','This Specialization covers the concepts and tools you will need throughout the entire data science pipeline, from asking the right kinds of questions to making inferences and publishing results, you’ll apply the skills learned by building a data product using real-world data. 
At completion, students will have a portfolio demonstrating their mastery of the material. Learn Data Science fundamentals with hands-on exercises','Varsha',1),

(7,'self-learning','Algorithms In Depth','Algorithms are taught here',9,true,1500,130,'2020-07-20','https://img-a.udemycdn.com/course/240x135/469292_6c3e_5.jpg?ahOjHxmGX_ZI5EXLYRHK3zyNcArTX7erLrv1OEhWQDdExYXN2OWauIPaBNdtPS5ha8lB9s4TankvtTfAvUJoqYQHylNd5XzB7ingAsjqrrFZfRzyiRTSQqnr9T3G',
'English, French','Algorithms,Dynamic Programming,Greedy Algorithm,Divide And Conquer Algorithms,Randomized Algorithm','Basics of Algorithms','Algorithms are the heart of computer science, and the subject has countless practical applications as well as intellectual depth.This specialization is an introduction to algorithms for learners with at least a little programming experience.The specialization is rigorous but emphasizes the big picture and conceptual understanding over low-level implementation and mathematical details.Learn Algorithms and 
their fundamentals here for better understanding.Hands-on are also covered','Anirudh',1),

(8,'self-learning','Shell Scripting','Shell Scripting is taught here',9,true,1100,120,'2019-02-02','https://img-a.udemycdn.com/course/240x135/1349660_ecfb_4.jpg?mpDALMunW6RzEa9hfOaRby2-snPrivm587WPwqpod8gPQkXjz6tLT08S_Y9rhNLPwF0m4BCLj1p1Av3Z3J-81U4h_16wCwA54vD37UTvXCdeqAQp2_GWJHm-Y2GNcw
','English, French','Shell Scripting and its Fudamentals','Basics of shell 
scripting','This course will help those new to shells and shell scripting to build a foundation with the Bash shell. We will learn several Bash shell commands that will allow you to navigate and use the shell for everyday tasks. We will also write a Bash shell script that will back up a directory and email the compressed file, a culmination of all the commands we’ll cover.Learn Shell Scripting and different technologies that use it','Gaurav',1),

(9,'assessment','Python and its fundamentals','Python is taught here',9,true,1700,90,'2020-05-24','https://img-a.udemycdn.com/course/240x135/903744_8eb2.jpg?XrSW_vQ7pfA1vk3UA1ZwcU3XewIQHNsDKij301m6nVlwCmt8HFC8q7A2DI6ChkvC0fwlPqTdju7gUD5KCWH1vtd0An3aalb7zmri2_4JFNCY9vEFk68ApG0CHQ
','English, French','Python Programming,Database (DBMS),Python Syntax And Semantics,Basic Programming Language','Basics of python','This Specialization builds on the success of the Python for Everybody course and will introduce fundamental programming concepts including data structures, networked application program interfaces, and databases, using the Python programming language,
you’ll use the technologies learned throughout the Specialization to design and create your own  applications for data retrieval, processing, and visualization.Learn Python and its overview by Ishaan.
 Hands-on are also covered. Ishaan is having 15 years of experience','Ishaan',1),

(10,'assessment','Linux and its fundamentals','Linux is taught here',10,false,1250,60,'2021-01-10','https://img-a.udemycdn.com/course/240x135/1523066_334c_14.jpg?Md5miAxoCQKPdWT_Hx_bu4j2zplmjiizoIWhBybzrBc_QY4bFFWO2VL0GQJL_0mUN0fLc5scrJH0BXk6pvhXgGrlWPQLhdSbGRE7Ifug3020tTC_jtorIAxr95F7bCs
','English, French','Linux and Operating Systems','Basics of operating systems',' Linux and Git Specialization will give you a strong foundation for working comfortably and productively in open source development communities. By completing the Specialization, you’ll have a better understanding of the Linux environment, as well as methods and tools required to successfully use it, and you’ll know how to use Git, the distributed version control system.Learn
 Linux,its overview and operating systems,their categories. Hands-on are also covered in this course','Jatin Chandra',1),

(11,'assessment','Cyber Security','Cyber Security is taught here',10,true,1020,110,'2019-04-02','https://img-a.udemycdn.com/course/240x135/300416_f738_4.jpg?0CkJmRDacFEIQBmVPzf2Iy1tj6j6hVhDcFEOc4tk7BKpI6VtPo_E0vFQh2xcOLY1i6Rb82u3HMXc_RpYakupYp-oUKrthHvfsvdPN06LS_pAhF05XAG5dQ5ebcBz05Q','English, French','Cyber Security and its fundamentals','Basics of cybersecurity',
'Develop knowledge of cybersecurity analyst tools including data protection; endpoint protection; SIEM; and systems and network fundamentals.Learn about key compliance and threat intelligence topics important in today’s cybersecurity landscape.Gain skills for incident responses and forensics with real-world cybersecurity case studies.
Learn Cyber Security,its overview and this course also covers many use cases of cybersecurity with real-time examples','Krishna Dev',1),

(12,'assessment','Cryptography','Cryptography is taught here',10,true,1250,90,'2019-11-11','https://img-a.udemycdn.com/course/240x135/3169510_2839_5.jpg?H1ISm2PGQRQZmNsDHfpzpv5BCDJAiRk08vs-m4SKJXNKD79HEIBHTt1X-6OgPT8kKhfiKkWH8wl-XoHf_VvNl3-qivuyeYKxbYIyQHhnV4ujcbluZIUG9N7-FmcOAA','English, French','Cryptography,Encryption and Decryption',
'Basics of hashing and cryptographic keys','Cryptography is an indispensable tool for protecting information in computer systems. In this course you will learn the inner workings of cryptographic systems and how to correctly use them in real-world applications. The course begins with a detailed discussion of how two parties who have a shared secret key can communicate securely when a powerful adversary eavesdrops and tampers with traffic. 
We will examine many deployed protocols and analyze mistakes in existing systems. Learn Cryptography,its overview and different encryption techniques.Hands-on are also covered in this course','Madhav Rathod',1),

(13,'instructor-led','Machine Learning','ML is taught here',7,true,850,190,'2020-04-22','https://img-a.udemycdn.com/course/240x135/950390_270f_3.jpg?Ngx0j5pUkVGKSW7AnGPdSfZipEhp4j4G2mJjV_hJNQXcWgNnrAFGAdkHgjJFdXocpG8UNhQ33nmT5fQEQoIeDZyEBJldLqPjN4T4VLZPK-coPh_gNK7UW5K0awCN
','English, French','Logistic Regression,Artificial Neural Network,Machine Learning (ML) Algorithms,Machine Learning','Basics of python',
'This course provides a broad introduction to machine learning, datamining, and statistical pattern recognition. Topics include: (i) Supervised learning (parametric/non-parametric algorithms, support vector machines, kernels, neural networks). (ii) Unsupervised learning (clustering, dimensionality reduction, recommender systems, deep learning). 
(iii) Best practices in machine learning (bias/variance theory; innovation process in machine learning and AI).','Sandeep',2),

(14,'instructor-led','Java Core and Advanced','Java is taught here',7,true,980,190,'2020-02-21','https://img-a.udemycdn.com/course/240x135/827692_91ad_2.jpg?h4AzideQHNoIbXXZ_mGxC87PuEOQpsefj9Zy50tJyyJbMJPwut690TSbUHSVLn6IIgxEo7s0wT5sWYwKx1ETwoenNPD3_07_HR_-hTQqh7w-Hkan4jLK_L4ag_MN
','English, French','Java Programming,Problem Solving,Programming Principles','Basics of Oops','In this course, students will learn fundamental Java and other real-time examples.
 The focus will be on learning about java, oops concepts, and best practices that can be immediately implemented in real-time.Designed for beginners, this Specialization will teach you core programming concepts and equip you to write programs to solve complex problems. In addition, 
you will gain the foundational skills a software engineer needs to solve real-world problems, from designing algorithms to testing and debugging your programs.','Kishore',2),

(15,'instructor-led','Artificial Intelligence','AI is taught here',7,true,790,190,'2021-01-22','https://img-b.udemycdn.com/course/240x135/1219332_bdd7.jpg?secure=_P-Vp_uOKwZsRTRJ0Ldecw%3D%3D%2C1614496107',
'English, French','Workflow of Machine Learning projects,AI terminology,AI strategy,Workflow of Data Science projects','Real time use of AI','In this course, students will learn fundamental artificial intelligence techniques that can be used 
to make sense of real life use cases.The meaning behind common AI terminology, including neural networks, machine learning, deep learning, and data science,What AI realistically can--and cannot--do?How to spot opportunities to apply AI to problems in your own organization?How to work with an AI team and build an AI strategy in your company?','Ravinder',2),

(16,'instructor-led','C and C++','C++ is taught here',8,true,850,150,'2021-02-12','https://img-b.udemycdn.com/course/240x135/1576854_9aeb_2.jpg?secure=CaiAFl5JQoFBvF1t-h34cw%3D%3D%2C1614496244','English, French','C and C++','Basics of C++','Learn C++ fundamentals
 with hands-on exercises.Create highly efficient compiled code that runs with minimal overhead.This Specialization is intended for all programming enthusiasts, as well as beginners, computer and other scientists, and artificial intelligence enthusiasts seeking to develop their programming skills in the foundational languages of C and C++.','Abhishek',2),

(17,'self-learning','Robotics','Robotics is taught here',8,false,500,150,'2019-05-10','https://img-a.udemycdn.com/course/240x135/2580536_b493.jpg?dLu06nB3tSrH5OIobEhhLSZpZXhWqosOhBFV3TBbCbQwpC6plz8WxFBsKO5o9a4ITExK9SuI9HI4TEjflolIxXvJZ7jtwIWFDm6OVxGOUS6OQB9M4KrSjD9CGVQ
','English, French','Motion Planning,Particle Filter,Matlab,Robotics,Quadcoper,Automated Planning And Scheduling','Basics
 of Programming Languages','Learn Robotics fundamentals with hands-on exercises.The Introduction to Robotics Specialization introduces you to the concepts of robot flight and movement, how robots perceive their environment, and how they adjust their movements to avoid obstacles, navigate difficult terrains and accomplish complex tasks such as construction and disaster recovery.Create highly efficient compiled code that runs with minimal overhead.','Siri Sai',2),

(18,'self-learning','Data Science','DS is taught here',8,true,700,120,'2019-06-08','https://img-b.udemycdn.com/course/240x135/1754098_e0df_3.jpg?secure=L-47DCsluRKp7ZFEhzV3mg%3D%3D%2C1614496359','English, French',
'R Programming,Regression Analysis,Data Science,Rstudio,Data Analysis,Debugging,Data Manipulation','Basics of python','This Specialization covers the concepts and tools you will need throughout the entire data science pipeline, from asking the right kinds of questions to making inferences and publishing results, you’ll apply the skills learned by building a data product using real-world data. 
At completion, students will have a portfolio demonstrating their mastery of the material. Learn Data Science fundamentals with hands-on exercises','Varsha',2),

(19,'self-learning','Algorithms In Depth','Algorithms are taught here',9,true,350,150,'2020-07-20','https://img-a.udemycdn.com/course/240x135/469292_6c3e_5.jpg?ahOjHxmGX_ZI5EXLYRHK3zyNcArTX7erLrv1OEhWQDdExYXN2OWauIPaBNdtPS5ha8lB9s4TankvtTfAvUJoqYQHylNd5XzB7ingAsjqrrFZfRzyiRTSQqnr9T3G',
'English, French','Algorithms,Dynamic Programming,Greedy Algorithm,Divide And Conquer Algorithms,Randomized Algorithm',
'Basics of Algorithms','Algorithms are the heart of computer science, and the subject has countless practical applications as well as intellectual depth.This specialization is an introduction to algorithms for learners with at least a little programming experience.The specialization is rigorous but emphasizes the big picture and conceptual understanding over low-level implementation and mathematical details.Learn Algorithms and their fundamentals here for better understanding.Hands-on are also covered','Anirudh',2),

(20,'self-learning','Shell Scripting','Shell Scripting is taught here',9,true,320,120,'2019-02-02','https://img-a.udemycdn.com/course/240x135/1349660_ecfb_4.jpg?mpDALMunW6RzEa9hfOaRby2-snPrivm587WPwqpod8gPQkXjz6tLT08S_Y9rhNLPwF0m4BCLj1p1Av3Z3J-81U4h_16wCwA54vD37UTvXCdeqAQp2_GWJHm-Y2GNcw
','English, French',
'Shell Scripting and its Fudamentals','Basics of shell scripting','This course will help those new to shells and shell scripting to build a foundation with the Bash shell. We will learn several Bash shell commands that will allow you to navigate and use the shell for everyday tasks. We will also write a Bash shell script that will back up a directory and email the compressed file, a culmination of all the commands we’ll cover.Learn Shell Scripting and different technologies that use it','Gaurav',2),

(21,'assessment','Python and its fundamentals','Python is taught here',9,true,600,80,'2020-05-24','https://img-a.udemycdn.com/course/240x135/903744_8eb2.jpg?XrSW_vQ7pfA1vk3UA1ZwcU3XewIQHNsDKij301m6nVlwCmt8HFC8q7A2DI6ChkvC0fwlPqTdju7gUD5KCWH1vtd0An3aalb7zmri2_4JFNCY9vEFk68ApG0CHQ
','English, French',
'Python Programming,Database (DBMS),Python Syntax And Semantics,Basic Programming Language','Basics of python','This Specialization builds on the success of the Python for Everybody course and will introduce fundamental programming concepts including data structures, networked application program interfaces, and databases, using the Python programming language,
you’ll use the technologies learned throughout the Specialization to design and create your own  applications for data retrieval, processing, and visualization.Learn Python and its overview by Ishaan.
 Hands-on are also covered. Ishaan is having 15 years of experience','Ishaan',2),

(22,'assessment','Linux and its fundamentals','Linux is taught here',10,false,450,90,'2021-01-10','https://img-a.udemycdn.com/course/240x135/1523066_334c_14.jpg?Md5miAxoCQKPdWT_Hx_bu4j2zplmjiizoIWhBybzrBc_QY4bFFWO2VL0GQJL_0mUN0fLc5scrJH0BXk6pvhXgGrlWPQLhdSbGRE7Ifug3020tTC_jtorIAxr95F7bCs
','English, French','Linux and Operating Systems','Basics of operating systems',
' Linux and Git Specialization will give you a strong foundation for working comfortably and productively in open source development communities.
 By completing the Specialization, you’ll have a better understanding of the Linux environment, as well as methods and tools required to successfully use it, and you’ll know how to use Git,
 the distributed version control system.Learn Linux,its overview and operating systems,their categories. Hands-on are also covered in this course','Jatin Chandra',2),

(23,'assessment','Cyber Security','Cyber Security is taught here',10,true,300,140,'2019-04-22','https://img-a.udemycdn.com/course/240x135/300416_f738_4.jpg?0CkJmRDacFEIQBmVPzf2Iy1tj6j6hVhDcFEOc4tk7BKpI6VtPo_E0vFQh2xcOLY1i6Rb82u3HMXc_RpYakupYp-oUKrthHvfsvdPN06LS_pAhF05XAG5dQ5ebcBz05Q','English, French','Cyber Security and its fundamentals',
'Basics of cybersecurity','Develop knowledge of cybersecurity analyst tools including data protection; endpoint protection; SIEM; and systems and network fundamentals.Learn about key compliance and threat intelligence topics important in today’s cybersecurity landscape.Gain skills for incident responses and forensics with real-world cybersecurity case studies.
Learn Cyber Security,its overview and this course also covers many use cases of cybersecurity with real-time examples','Krishna Dev',2),

(24,'assessment','Cryptography','Cryptography is taught here',10,true,400,120,'2021-04-22','https://img-a.udemycdn.com/course/240x135/3169510_2839_5.jpg?H1ISm2PGQRQZmNsDHfpzpv5BCDJAiRk08vs-m4SKJXNKD79HEIBHTt1X-6OgPT8kKhfiKkWH8wl-XoHf_VvNl3-qivuyeYKxbYIyQHhnV4ujcbluZIUG9N7-FmcOAA','English, French','Cryptography,Encryption and Decryption',
'Basics of hashing and cryptographic keys','Cryptography is an indispensable tool for protecting information in computer systems. In this course you will learn the inner workings of cryptographic systems and how to correctly use them in real-world applications. The course begins with a detailed discussion of how two parties who have a shared secret key can communicate securely when a powerful adversary eavesdrops and tampers with traffic. We will examine many deployed protocols and analyze mistakes in existing systems. 
Learn Cryptography,its overview and different encryption techniques.Hands-on are also covered in this course','Madhav Rathod',2),


(25,'instructor-led','Machine Learning','ML is taught here',7,true,400,90,'2020-04-22','https://img-a.udemycdn.com/course/240x135/950390_270f_3.jpg?Ngx0j5pUkVGKSW7AnGPdSfZipEhp4j4G2mJjV_hJNQXcWgNnrAFGAdkHgjJFdXocpG8UNhQ33nmT5fQEQoIeDZyEBJldLqPjN4T4VLZPK-coPh_gNK7UW5K0awCN
','English, French','Logistic Regression,Artificial Neural Network,Machine Learning (ML) Algorithms,Machine Learning','Basics of python','This course provides a broad introduction to machine learning, datamining, and statistical pattern recognition. Topics include: (i) Supervised learning (parametric/non-parametric algorithms, support vector machines, kernels, neural networks). (ii) Unsupervised learning (clustering, dimensionality reduction, recommender systems, deep learning). 
(iii) Best practices in machine learning (bias/variance theory; innovation process in machine learning and AI).','Sandeep',3),

(26,'instructor-led','Java Core and Advanced','Java is taught here',7,true,550,90,'2020-02-21','https://img-a.udemycdn.com/course/240x135/827692_91ad_2.jpg?h4AzideQHNoIbXXZ_mGxC87PuEOQpsefj9Zy50tJyyJbMJPwut690TSbUHSVLn6IIgxEo7s0wT5sWYwKx1ETwoenNPD3_07_HR_-hTQqh7w-Hkan4jLK_L4ag_MN
','English, French','Java Programming,Problem Solving,Programming Principles','Basics of Oops','In this course, students will learn fundamental Java and other real-time examples.
 The focus will be on learning about java, oops concepts, and best practices that can be immediately implemented in real-time.Designed for beginners, this Specialization will teach you core programming concepts and equip you to write programs to solve complex problems. In addition,
 you will gain the foundational skills a software engineer needs to solve real-world problems, from designing algorithms to testing and debugging your programs.','Kishore',3),

(27,'instructor-led','Artificial Intelligence','AI is taught here',7,true,600,90,'2019-04-22','https://img-b.udemycdn.com/course/240x135/1219332_bdd7.jpg?secure=_P-Vp_uOKwZsRTRJ0Ldecw%3D%3D%2C1614496107',
'English, French','Workflow of Machine Learning projects,AI terminology,AI strategy,Workflow of Data Science projects','Real time use of AI','In this course, students will learn fundamental artificial intelligence techniques that can be used 
to make sense of real life use cases.The meaning behind common AI terminology, including neural networks, machine learning, deep learning, and data science,What AI realistically can--and cannot--do?How to spot opportunities to apply AI to problems in your own organization?How to work with an AI team and build an AI strategy in your company?','Ravinder',3),

(28,'instructor-led','C and C++','C++ is taught here',8,true,650,90,'2019-04-22','https://img-b.udemycdn.com/course/240x135/1576854_9aeb_2.jpg?secure=CaiAFl5JQoFBvF1t-h34cw%3D%3D%2C1614496244','English, French','C and C++','Basics of C++','Learn C++ fundamentals with hands-on exercises.
Create highly efficient compiled code that runs with minimal overhead.This Specialization is intended for all programming enthusiasts, as well as beginners, computer and other scientists, and artificial intelligence enthusiasts seeking to develop their programming skills in the foundational languages of C and C++.','Abhishek',3),

(29,'self-learning','Robotics','Robotics is taught here',8,false,700,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/2580536_b493.jpg?dLu06nB3tSrH5OIobEhhLSZpZXhWqosOhBFV3TBbCbQwpC6plz8WxFBsKO5o9a4ITExK9SuI9HI4TEjflolIxXvJZ7jtwIWFDm6OVxGOUS6OQB9M4KrSjD9CGVQ
','English, French','Motion Planning,Particle Filter,Matlab,Robotics,Quadcoper,Automated Planning And Scheduling','Basics of Programming Languages',
'Learn Robotics fundamentals with hands-on exercises.The Introduction to Robotics Specialization introduces you to the concepts of robot flight and movement, how robots perceive their environment, and how they adjust their movements to avoid obstacles, navigate difficult terrains and accomplish complex tasks such as construction and disaster recovery.Create highly efficient compiled code that runs with minimal overhead.','Siri Sai',3),

(30,'self-learning','Data Science','DS is taught here',8,true,700,120,'2019-04-22','https://img-b.udemycdn.com/course/240x135/1754098_e0df_3.jpg?secure=L-47DCsluRKp7ZFEhzV3mg%3D%3D%2C1614496359',
'English, French','R Programming,Regression Analysis,Data Science,Rstudio,Data Analysis,Debugging,Data Manipulation','Basics of python',
'This Specialization covers the concepts and tools you will need throughout the entire data science pipeline, from asking the right kinds of questions to making inferences and publishing results, you’ll apply the skills learned by building a data product using real-world data.
At completion, students will have a portfolio demonstrating their mastery of the material. Learn Data Science fundamentals with hands-on exercises','Varsha',3),

(31,'self-learning','Algorithms In Depth','Algorithms are taught here',9,true,750,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/469292_6c3e_5.jpg?ahOjHxmGX_ZI5EXLYRHK3zyNcArTX7erLrv1OEhWQDdExYXN2OWauIPaBNdtPS5ha8lB9s4TankvtTfAvUJoqYQHylNd5XzB7ingAsjqrrFZfRzyiRTSQqnr9T3G',
'English, French','Algorithms,Dynamic Programming,Greedy Algorithm,Divide And Conquer Algorithms,Randomized Algorithm',
'Basics of Algorithms','Algorithms are the heart of computer science, and the subject has countless practical applications as well as intellectual depth.This specialization is an introduction to algorithms for learners with at least a little programming experience.The specialization is rigorous but emphasizes the big picture and conceptual understanding over low-level implementation and mathematical details.Learn Algorithms and their fundamentals here for better understanding.Hands-on are also covered','Anirudh',3),

(32,'self-learning','Shell Scripting','Shell Scripting is taught here',9,true,290,120,'2019-04-22','https://img-a.udemycdn.com/course/240x135/1349660_ecfb_4.jpg?mpDALMunW6RzEa9hfOaRby2-snPrivm587WPwqpod8gPQkXjz6tLT08S_Y9rhNLPwF0m4BCLj1p1Av3Z3J-81U4h_16wCwA54vD37UTvXCdeqAQp2_GWJHm-Y2GNcw
','English, French','Shell Scripting and its Fudamentals',
'Basics of shell scripting','This course will help those new to shells and shell scripting to build a foundation with the Bash shell. We will learn several Bash shell commands that will allow you to navigate and use the shell for everyday tasks. We will also write a Bash shell script that will back up a directory and email the compressed file, a culmination of all the commands we’ll cover.Learn Shell Scripting and different technologies that use it','Gaurav',3),

(33,'assessment','Python and its fundamentals','Python is taught here',9,true,310,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/903744_8eb2.jpg?XrSW_vQ7pfA1vk3UA1ZwcU3XewIQHNsDKij301m6nVlwCmt8HFC8q7A2DI6ChkvC0fwlPqTdju7gUD5KCWH1vtd0An3aalb7zmri2_4JFNCY9vEFk68ApG0CHQ
','English, French',
'Python Programming,Database (DBMS),Python Syntax And Semantics,Basic Programming Language','Basics of python','This Specialization builds on the success of the Python for Everybody course and will introduce fundamental programming concepts including data structures, networked application program interfaces, and databases, using the Python programming language,
you’ll use the technologies learned throughout the Specialization to design and create your own  applications for data retrieval, processing, and visualization.Learn Python and its overview by Ishaan.
 Hands-on are also covered. Ishaan is having 15 years of experience','Ishaan',3),

(34,'assessment','Linux and its fundamentals','Linux is taught here',10,false,450,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/1523066_334c_14.jpg?Md5miAxoCQKPdWT_Hx_bu4j2zplmjiizoIWhBybzrBc_QY4bFFWO2VL0GQJL_0mUN0fLc5scrJH0BXk6pvhXgGrlWPQLhdSbGRE7Ifug3020tTC_jtorIAxr95F7bCs
','English, French',
'Linux and Operating Systems','Basics of operating systems',' Linux and Git Specialization will give you a strong foundation for working comfortably and productively in open source development communities. By completing the Specialization, you’ll have a better understanding of the Linux environment, as well as methods and tools required to successfully use it, and you’ll know how to use Git, the distributed version control system.Learn Linux,its overview and operating systems,their categories. Hands-on are also covered in this course','Jatin Chandra',3),

(35,'assessment','Cyber Security','Cyber Security is taught here',10,true,430,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/300416_f738_4.jpg?0CkJmRDacFEIQBmVPzf2Iy1tj6j6hVhDcFEOc4tk7BKpI6VtPo_E0vFQh2xcOLY1i6Rb82u3HMXc_RpYakupYp-oUKrthHvfsvdPN06LS_pAhF05XAG5dQ5ebcBz05Q','English, French',
'Cyber Security and its fundamentals','Basics of cybersecurity','Develop knowledge of cybersecurity analyst tools including data protection; endpoint protection; SIEM; and systems and network fundamentals.Learn about key compliance and threat intelligence topics important in today’s cybersecurity landscape.Gain skills for incident responses and forensics with real-world cybersecurity case studies.
Learn Cyber Security,its overview and this course also covers many use cases of cybersecurity with real-time examples','Krishna Dev',3),

(36,'assessment','Cryptography','Cryptography is taught here',10,true,460,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/3169510_2839_5.jpg?H1ISm2PGQRQZmNsDHfpzpv5BCDJAiRk08vs-m4SKJXNKD79HEIBHTt1X-6OgPT8kKhfiKkWH8wl-XoHf_VvNl3-qivuyeYKxbYIyQHhnV4ujcbluZIUG9N7-FmcOAA','English, French',
'Cryptography,Encryption and Decryption','Basics of hashing and cryptographic keys','Cryptography is an indispensable tool for protecting information in computer systems. In this course you will learn the inner workings of cryptographic systems and how to correctly use them in real-world applications. The course begins with a detailed discussion of how two parties who have a shared secret key can communicate securely when a powerful adversary eavesdrops and tampers with traffic. We will examine many deployed protocols and analyze mistakes in existing systems. 
Learn Cryptography,its overview and different encryption techniques.Hands-on are also covered in this course','Madhav Rathod',3),


(37,'instructor-led','Machine Learning','ML is taught here',7,true,1100,90,'2020-04-22','https://img-a.udemycdn.com/course/240x135/950390_270f_3.jpg?Ngx0j5pUkVGKSW7AnGPdSfZipEhp4j4G2mJjV_hJNQXcWgNnrAFGAdkHgjJFdXocpG8UNhQ33nmT5fQEQoIeDZyEBJldLqPjN4T4VLZPK-coPh_gNK7UW5K0awCN
','English, French','Logistic Regression,Artificial Neural Network,Machine Learning (ML) Algorithms,Machine Learning','Basics of python','This course provides a broad introduction to machine learning, datamining, and statistical pattern recognition. Topics include: (i) Supervised learning (parametric/non-parametric algorithms, support vector machines, kernels, neural networks). (ii) Unsupervised learning (clustering, dimensionality reduction, recommender systems, deep learning). 
(iii) Best practices in machine learning (bias/variance theory; innovation process in machine learning and AI).','Sandeep',4),

(38,'instructor-led','Java Core and Advanced','Java is taught here',7,true,1500,90,'2020-02-21','https://img-a.udemycdn.com/course/240x135/827692_91ad_2.jpg?h4AzideQHNoIbXXZ_mGxC87PuEOQpsefj9Zy50tJyyJbMJPwut690TSbUHSVLn6IIgxEo7s0wT5sWYwKx1ETwoenNPD3_07_HR_-hTQqh7w-Hkan4jLK_L4ag_MN
','English, French','Java Programming,Problem Solving,Programming Principles','Basics of Oops','In this course, students will learn fundamental Java and other real-time examples.
 The focus will be on learning about java, oops concepts, and best practices that can be immediately implemented in real-time.Designed for beginners, this Specialization will teach you core programming concepts and equip you to write programs to solve complex problems. In addition, 
you will gain the foundational skills a software engineer needs to solve real-world problems, from designing algorithms to testing and debugging your programs.','Kishore',4),

(39,'instructor-led','Artificial Intelligence','AI is taught here',7,true,1050,90,'2019-04-22','https://img-b.udemycdn.com/course/240x135/1219332_bdd7.jpg?secure=_P-Vp_uOKwZsRTRJ0Ldecw%3D%3D%2C1614496107',
'English, French','Workflow of Machine Learning projects,AI terminology,AI strategy,Workflow of Data Science projects','Real time use of AI','In this course, students will learn fundamental artificial intelligence techniques that can be used 
to make sense of real life use cases.The meaning behind common AI terminology, including neural networks, machine learning, deep learning, and data science,What AI realistically can--and cannot--do?How to spot opportunities to apply AI to problems in your own organization?How to work with an AI team and build an AI strategy in your company?','Ravinder',4),

(40,'instructor-led','C and C++','C++ is taught here',8,true,1200,90,'2019-04-22','https://img-b.udemycdn.com/course/240x135/1576854_9aeb_2.jpg?secure=CaiAFl5JQoFBvF1t-h34cw%3D%3D%2C1614496244','English, French',
'C and C++','Basics of C++','Learn C++ fundamentals with hands-on exercises.
Create highly efficient compiled code that runs with minimal overhead.This Specialization is intended for all programming enthusiasts, as well as beginners, computer and other scientists, and artificial intelligence enthusiasts seeking to develop their programming skills in the foundational languages of C and C++.','Abhishek',4),

(41,'self-learning','Robotics','Robotics is taught here',8,false,1090,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/2580536_b493.jpg?dLu06nB3tSrH5OIobEhhLSZpZXhWqosOhBFV3TBbCbQwpC6plz8WxFBsKO5o9a4ITExK9SuI9HI4TEjflolIxXvJZ7jtwIWFDm6OVxGOUS6OQB9M4KrSjD9CGVQ',
'English, French','Motion Planning,Particle Filter,Matlab,Robotics,Quadcoper,Automated Planning And Scheduling','Basics of Programming Languages',
'Learn Robotics fundamentals with hands-on exercises.The Introduction to Robotics Specialization introduces you to the concepts of robot flight and movement, how robots perceive their environment, and how they adjust their movements to avoid obstacles, navigate difficult terrains and accomplish complex tasks such as construction and disaster recovery.Create highly efficient compiled code that runs with minimal overhead.','Siri Sai',4),

(42,'self-learning','Data Science','DS is taught here',8,true,1250,120,'2019-04-22','https://img-b.udemycdn.com/course/240x135/1754098_e0df_3.jpg?secure=L-47DCsluRKp7ZFEhzV3mg%3D%3D%2C1614496359',
'English, French','R Programming,Regression Analysis,Data Science,Rstudio,Data Analysis,Debugging,Data Manipulation','Basics of python',
'This Specialization covers the concepts and tools you will need throughout the entire data science pipeline, from asking the right kinds of questions to making inferences and publishing results, you’ll apply the skills learned by building a data product using real-world data. 
At completion, students will have a portfolio demonstrating their mastery of the material. Learn Data Science fundamentals with hands-on exercises','Varsha',4),

(43,'self-learning','Algorithms In Depth','Algorithms are taught here',9,true,1750,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/469292_6c3e_5.jpg?ahOjHxmGX_ZI5EXLYRHK3zyNcArTX7erLrv1OEhWQDdExYXN2OWauIPaBNdtPS5ha8lB9s4TankvtTfAvUJoqYQHylNd5XzB7ingAsjqrrFZfRzyiRTSQqnr9T3G',
'English, French','Algorithms,Dynamic Programming,Greedy Algorithm,Divide And Conquer Algorithms,Randomized Algorithm',
'Basics of Algorithms','Algorithms are the heart of computer science, and the subject has countless practical applications as well as intellectual depth.This specialization is an introduction to algorithms for learners with at least a little programming experience.The specialization is rigorous but emphasizes the big picture and conceptual understanding over low-level implementation and mathematical details.Learn Algorithms and their fundamentals here for better understanding.Hands-on are also covered','Anirudh',4),

(44,'self-learning','Shell Scripting','Shell Scripting is taught here',9,true,1090,120,'2019-04-22','https://img-a.udemycdn.com/course/240x135/1349660_ecfb_4.jpg?mpDALMunW6RzEa9hfOaRby2-snPrivm587WPwqpod8gPQkXjz6tLT08S_Y9rhNLPwF0m4BCLj1p1Av3Z3J-81U4h_16wCwA54vD37UTvXCdeqAQp2_GWJHm-Y2GNcw
','English, French','Shell Scripting and its Fudamentals',
'Basics of shell scripting','This course will help those new to shells and shell scripting to build a foundation with the Bash shell. We will learn several Bash shell commands that will allow you to navigate and use the shell for everyday tasks. We will also write a Bash shell script that will back up a directory and email the compressed file, a culmination of all the commands we’ll cover.Learn Shell Scripting and different technologies that use it','Gaurav',4),

(45,'assessment','Python and its fundamentals','Python is taught here',9,true,1600,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/903744_8eb2.jpg?XrSW_vQ7pfA1vk3UA1ZwcU3XewIQHNsDKij301m6nVlwCmt8HFC8q7A2DI6ChkvC0fwlPqTdju7gUD5KCWH1vtd0An3aalb7zmri2_4JFNCY9vEFk68ApG0CHQ
','English, French','Python Programming,Database (DBMS),Python Syntax And Semantics,Basic Programming Language',
'Basics of python','This Specialization builds on the success of the Python for Everybody course and will introduce fundamental programming concepts including data structures, networked application program interfaces, and databases, using the Python programming language,
you’ll use the technologies learned throughout the Specialization to design and create your own  applications for data retrieval, processing, and visualization.Learn Python and its overview by Ishaan.
 Hands-on are also covered. Ishaan is having 15 years of experience','Ishaan',4),

(46,'assessment','Linux and its fundamentals','Linux is taught here',10,false,1000,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/1523066_334c_14.jpg?Md5miAxoCQKPdWT_Hx_bu4j2zplmjiizoIWhBybzrBc_QY4bFFWO2VL0GQJL_0mUN0fLc5scrJH0BXk6pvhXgGrlWPQLhdSbGRE7Ifug3020tTC_jtorIAxr95F7bCs
','English, French','Linux and Operating Systems',
'Basics of operating systems',' Linux and Git Specialization will give you a strong foundation for working comfortably and productively in open source development communities. By completing the Specialization, you’ll have a better understanding of the Linux environment, as well as methods and tools required to successfully use it, and you’ll know how to use Git, the distributed version control system.Learn Linux,its overview and operating systems,their categories. Hands-on are also covered in this course','Jatin Chandra',4),

(47,'assessment','Cyber Security','Cyber Security is taught here',10,true,950,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/300416_f738_4.jpg?0CkJmRDacFEIQBmVPzf2Iy1tj6j6hVhDcFEOc4tk7BKpI6VtPo_E0vFQh2xcOLY1i6Rb82u3HMXc_RpYakupYp-oUKrthHvfsvdPN06LS_pAhF05XAG5dQ5ebcBz05Q','English, French',
'Cyber Security and its fundamentals','Basics of cybersecurity','Develop knowledge of cybersecurity analyst tools including data protection; endpoint protection; SIEM; and systems and network fundamentals.Learn about key compliance and threat intelligence topics important in today’s cybersecurity landscape.Gain skills for incident responses and forensics with real-world cybersecurity case studies.
Learn Cyber Security,its overview and this course also covers many use cases of cybersecurity with real-time examples','Krishna Dev',4),

(48,'assessment','Cryptography','Cryptography is taught here',10,true,800,90,'2019-04-22','https://img-a.udemycdn.com/course/240x135/3169510_2839_5.jpg?H1ISm2PGQRQZmNsDHfpzpv5BCDJAiRk08vs-m4SKJXNKD79HEIBHTt1X-6OgPT8kKhfiKkWH8wl-XoHf_VvNl3-qivuyeYKxbYIyQHhnV4ujcbluZIUG9N7-FmcOAA','English, French',
'Cryptography,Encryption and Decryption','Basics of hashing and cryptographic keys','Cryptography is an indispensable tool for protecting information in computer systems. In this course you will learn the inner workings of cryptographic systems and how to correctly use them in real-world applications. The course begins with a detailed discussion of how two parties who have a shared secret key can communicate securely when a powerful adversary eavesdrops and tampers with traffic. We will examine many deployed protocols and analyze mistakes in existing systems. 
Learn Cryptography,its overview and different encryption techniques.Hands-on are also covered in this course','Madhav Rathod',4);

insert into review (reviewId,courseId,userId,description) values
(1,1,1,"The course is structured with contents meeting the objectives of the course.
 Special credit to all the teachers, I left as if they were explaining it on the face. The language was very clear and understandable.My learning was enhanced, Now i can get a job anywhere. This was a life changing course."),
(2,11,2,"An excellent course:  it provides learners with the concepts and skills necessary for searching and researching information in libraries and online. Lectures are clear and well organized. 
This course has taught me a lot of techniques in searching information for my  academic researches."),
(3,5,3,"Very interesting course, better done when in an academic context and with an ongoing project to carry out the exercices for.I love this course. 
It helps me with my teaching and personal development. Besides, I know several reference management tools from this course. Storing the documents is really complicated and makes me in a mess. Thank you for your tutoring and sharing."),
(4,8,4,"An excellent course, it provides learners with the concepts and skills necessary for searching and researching information in
 libraries and online. Lectures are clear and well organized."),
(5,6,5,"I love this course. It helps me with my teaching and personal development.This was my first time taking a course in this format and it far exceeded my expectations."),
(6,9,6,"I really liked this course - it was short, useful and to the point.I would strongly recommend these courses to other individuals who require additional software skills with limited time availability."),
(7,13,1,"The course was very comprehensive and easy to understand.The course was very comprehensive and easy to understand.One of the best training classes I have done. I really like the hands on instructions with the instructors screen beside mine and the phone/com was great to have on hand for questions."),
(8,14,2,"Amazing course full of very useful information!"),
(9,23,3,"I found this course really excellent and useful. I would recommend it to anyone interested in learning the basic and proper use of it."),
(10,20,4,"Very nice and useful information are received in this course.Very nice and easy understandable texts."),
(11,19,5,"The course is very helpful especially for those in the academic profession or anyone with library access to literature and materials. "),
(12,15,6,"A very amazing and comprehensive course that leads you to how to carry out your search and document it the correct way."),
(13,26,1,"I am glad I did this course. I have found the lecture on reference management tools especially helpful."),
(14,29,2,"I think this course is great for anyone who wants to make a great research paper.So I recommend it."),
(15,35,3,"A very good course for a beginner who want to enter in to fields of research."),
(16,31,4,"Excellent, well-structured and comprehensive,  surely a source of reference"),
(17,25,5,"This was really helpful, I was able to organize all my information."),
(18,30,6,"As an experienced researcher I learned a lot from doing this course"),
(19,38,1,"Excellent, and important to investigation and intellectual working"),
(20,48,2,"Great course! I have learnt how to search for academically.I figured it out and the explanations given by the instructor was otherwise detalied."),
(21,41,3,"An excellent course, met all the course objectives."),
(22,44,4,"It was very effective and helpful!Excellent, and important to investigation and intellectual working"),
(23,47,5,"A very valuable set of resources!As an experienced researcher I learned a lot from doing this course"),
(24,46,6,"It was a fast and educative course that brought a lot into perspective."),
(25,2,1,"The course is structured with contents meeting the objectives of the course. Special credit to all the teachers, I left as if they were explaining it on the face. The language was very clear and understandable.
My learning was enhanced, Now i can get a job anywhere. This was a life changing course"),
(26,12,2,"An excellent course:  it provides learners with the concepts and skills necessary for searching and researching information in libraries and online. Lectures are clear and well organized. 
This course has taught me a lot of techniques in searching information for my  academic researches."),
(27,3,3,"Very interesting course, better done when in an academic context and with an ongoing project to carry out the exercices for.I love this course. It helps me with my teaching and personal development. Besides, I know several reference management tools from this course. Storing the documents is really complicated and makes me in a mess. Thank you for your tutoring and sharing."),
(28,10,4,"An excellent course, it provides learners with the concepts and skills necessary for searching and researching information in libraries and online. Lectures are clear and well organized."),
(29,4,5,"I love this course. It helps me with my teaching and personal development.This was my first time taking a course in this format and it far exceeded my expectations."),
(30,7,6,"I really liked this course - it was short, useful and to the point.I would strongly recommend these courses to other individuals who require additional software skills with limited time availability."),
(31,16,1,"The course was very comprehensive and easy to understand.The course was very comprehensive and easy to understand."),
(32,17,2,"Amazing course full of very useful information!"),
(33,21,3,"I found this course really excellent and useful. I would recommend it to anyone interested in learning the basic and proper use of it."),
(34,18,4,"Very nice and useful information are received in this course.Very nice and easy understandable texts."),
(35,22,5,"The course is very helpful especially for those in the academic profession or anyone with library access to literature and materials. "),
(36,24,6,"A very amazing and comprehensive course that leads you to how to carry out your search and document it the correct way."),
(37,28,1,"I am glad I did this course. I have found the lecture on reference management tools especially helpful."),
(38,32,2,"I think this course is great for anyone who wants to make a great research paper.So I recommend it."),
(39,27,3,"A very good course for a beginner who want to enter in to fields of research."),
(40,33,4,"Excellent, well-structured and comprehensive,  surely a source of reference"),
(41,36,5,"This was really helpful, I was able to organize all my information."),
(42,34,6,"As an experienced researcher I learned a lot from doing this course"),
(43,45,1,"Excellent, and important to investigation and intellectual working"),
(44,42,2,"Great course! I have learnt how to search for academically.I figured it out and the explanations given by the instructor was otherwise detalied."),
(45,39,3,"An excellent course, met all the course objectives."),
(46,37,4,"It was very effective and helpful!"),
(47,40,5,"A very valuable set of resources!"),
(48,43,6,"It was a fast and educative course that brought a lot into perspective.");

insert into orders(orderId,userId,courseId,paymentNo,isComplete,serviceId) values
(1,1,1,1001,false,1),
(2,2,11,1002,false,1),
(3,3,5,1003,false,1),
(4,4,8,1004,false,1),
(5,5,6,1005,false,1),
(6,6,9,1006,false,1),
(7,1,13,1007,false,2),
(8,2,14,1008,false,2),
(9,3,23,1009,false,2),
(10,4,20,1010,false,2),
(11,5,19,1011,false,2),
(12,6,15,1012,false,2),
(13,1,26,1013,false,3),
(14,2,29,1014,false,3),
(15,3,35,1015,false,3),
(16,4,31,1016,false,3),
(17,5,25,1017,false,3),
(18,6,30,1018,false,3),
(19,1,38,1019,false,4),
(20,2,48,1020,false,4),
(21,3,41,1021,false,4),
(22,4,44,1022,false,4),
(23,5,47,1023,false,4),
(24,6,46,1024,false,4);

