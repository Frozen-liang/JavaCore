## 2.File类

### 2.1File类概述和构造方法【应用】

- File类介绍

  - 它是文件和目录路径名的抽象表示
  - 文件和目录是可以通过File封装成对象的
  - 对于File而言,其封装的并不是一个真正存在的文件,仅仅是一个路径名而已.它可以是存在的,也可以是不存在的.将来是要通过具体的操作把这个路径的内容转换为具体存在的

- File类的构造方法

  | 方法名                              | 说明                                                        |
  | ----------------------------------- | ----------------------------------------------------------- |
  | File(String   pathname)             | 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例 |
  | File(String   parent, String child) | 从父路径名字符串和子路径名字符串创建新的   File实例         |
  | File(File   parent, String child)   | 从父抽象路径名和子路径名字符串创建新的   File实例           |

- 示例代码

  ```java
  public class FileDemo01 {
      public static void main(String[] args) {
          //File(String pathname): 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例
          File f1 = new File("E:\\itcast\\java.txt");
          System.out.println(f1);
  
          //File(String parent, String child): 从父路径名字符串和子路径名字符串创建新的 File实例
          File f2 = new File("E:\\itcast","java.txt");
          System.out.println(f2);
  
          //File(File parent, String child): 从父抽象路径名和子路径名字符串创建新的 File实例
          File f3 = new File("E:\\itcast");
          File f4 = new File(f3,"java.txt");
          System.out.println(f4);
      }
  }
  ```

### 2.2绝对路径和相对路径【理解】

- 绝对路径

  是一个完整的路径,从盘符开始

- 相对路径

  是一个简化的路径,相对当前项目下的路径

- 示例代码

  ```java
  public class FileDemo02 {
      public static void main(String[] args) {
          // 是一个完整的路径,从盘符开始
          File file1 = new File("D:\\itheima\\a.txt");
  
          // 是一个简化的路径,从当前项目根目录开始
          File file2 = new File("a.txt");
          File file3 = new File("模块名\\a.txt");
      }
  }
  ```

### 2.3File类创建功能【应用】

- 方法分类

  | 方法名                         | 说明                                                         |
  | ------------------------------ | ------------------------------------------------------------ |
  | public boolean createNewFile() | 当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件 |
  | public boolean mkdir()         | 创建由此抽象路径名命名的目录                                 |
  | public boolean mkdirs()        | 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录   |

- 示例代码.4File类删除功能【应用】

  ```java
  public class FileDemo02 {
      public static void main(String[] args) throws IOException {
          //需求1：我要在E:\\itcast目录下创建一个文件java.txt
          File f1 = new File("E:\\itcast\\java.txt");
          System.out.println(f1.createNewFile());
          System.out.println("--------");
  
          //需求2：我要在E:\\itcast目录下创建一个目录JavaSE
          File f2 = new File("E:\\itcast\\JavaSE");
          System.out.println(f2.mkdir());
          System.out.println("--------");
  
          //需求3：我要在E:\\itcast目录下创建一个多级目录JavaWEB\\HTML
          File f3 = new File("E:\\itcast\\JavaWEB\\HTML");
  //        System.out.println(f3.mkdir());
          System.out.println(f3.mkdirs());
          System.out.println("--------");
  
          //需求4：我要在E:\\itcast目录下创建一个文件javase.txt
          File f4 = new File("E:\\itcast\\javase.txt");
  //        System.out.println(f4.mkdir());
          System.out.println(f4.createNewFile());
      }
  }
  ```

### 2.4File类删除功能【应用】

- 方法分类

  | 方法名                    | 说明                               |
  | ------------------------- | ---------------------------------- |
  | public boolean   delete() | 删除由此抽象路径名表示的文件或目录 |

- 示例代码

  ```java
  public class FileDemo03 {
      public static void main(String[] args) throws IOException {
  //        File f1 = new File("E:\\itcast\\java.txt");
          //需求1：在当前模块目录下创建java.txt文件
          File f1 = new File("myFile\\java.txt");
  //        System.out.println(f1.createNewFile());
  
          //需求2：删除当前模块目录下的java.txt文件
          System.out.println(f1.delete());
          System.out.println("--------");
  
          //需求3：在当前模块目录下创建itcast目录
          File f2 = new File("myFile\\itcast");
  //        System.out.println(f2.mkdir());
  
          //需求4：删除当前模块目录下的itcast目录
          System.out.println(f2.delete());
          System.out.println("--------");
  
          //需求5：在当前模块下创建一个目录itcast,然后在该目录下创建一个文件java.txt
          File f3 = new File("myFile\\itcast");
  //        System.out.println(f3.mkdir());
          File f4 = new File("myFile\\itcast\\java.txt");
  //        System.out.println(f4.createNewFile());
  
          //需求6：删除当前模块下的目录itcast
          System.out.println(f4.delete());
          System.out.println(f3.delete());
      }
  }
  ```

### 2.5File类判断和获取功能【应用】

- 判断功能

  | 方法名                         | 说明                                 |
  | ------------------------------ | ------------------------------------ |
  | public   boolean isDirectory() | 测试此抽象路径名表示的File是否为目录 |
  | public   boolean isFile()      | 测试此抽象路径名表示的File是否为文件 |
  | public   boolean   exists()    | 测试此抽象路径名表示的File是否存在   |

- 获取功能

  | 方法名                            | 说明                                                   |
  | --------------------------------- | ------------------------------------------------------ |
  | public   String getAbsolutePath() | 返回此抽象路径名的绝对路径名字符串                     |
  | public   String getPath()         | 将此抽象路径名转换为路径名字符串                       |
  | public   String getName()         | 返回由此抽象路径名表示的文件或目录的名称               |
  | public   File[] listFiles()       | 返回此抽象路径名表示的目录中的文件和目录的File对象数组 |

- 示例代码

  ```java
  public class FileDemo04 {
      public static void main(String[] args) {
          //创建一个File对象
          File f = new File("myFile\\java.txt");
  
  //        public boolean isDirectory()：测试此抽象路径名表示的File是否为目录
  //        public boolean isFile()：测试此抽象路径名表示的File是否为文件
  //        public boolean exists()：测试此抽象路径名表示的File是否存在
          System.out.println(f.isDirectory());
          System.out.println(f.isFile());
          System.out.println(f.exists());
  
  //        public String getAbsolutePath()：返回此抽象路径名的绝对路径名字符串
  //        public String getPath()：将此抽象路径名转换为路径名字符串
  //        public String getName()：返回由此抽象路径名表示的文件或目录的名称
          System.out.println(f.getAbsolutePath());
          System.out.println(f.getPath());
          System.out.println(f.getName());
          System.out.println("--------");
  
  //        public File[] listFiles()：返回此抽象路径名表示的目录中的文件和目录的File对象数组
          File f2 = new File("E:\\itcast");
          File[] fileArray = f2.listFiles();
          for(File file : fileArray) {
  //            System.out.println(file);
  //            System.out.println(file.getName());
              if(file.isFile()) {
                  System.out.println(file.getName());
              }
          }
      }
  }
  ```

### 2.6File类练习一【应用】

- 案例需求

  在当前模块下的aaa文件夹中创建一个a.txt文件

- 实现步骤

  - 创建File对象,指向aaa文件夹
  - 判断aaa文件夹是否存在,如果不存在则创建
  - 创建File对象,指向aaa文件夹下的a.txt文件
  - 创建这个文件

- 代码实现

  ```java
  public class Test1 {
      public static void main(String[] args) throws IOException {
          //练习一：在当前模块下的aaa文件夹中创建一个a.txt文件
         /* File file = new File("filemodule\\aaa\\a.txt");
          file.createNewFile();*/
          //注意点:文件所在的文件夹必须要存在.
  
        	//1.创建File对象,指向aaa文件夹
          File file = new File("filemodule\\aaa");
        	//2.判断aaa文件夹是否存在,如果不存在则创建
          if(!file.exists()){
              //如果文件夹不存在,就创建出来
              file.mkdirs();
          }
        	//3.创建File对象,指向aaa文件夹下的a.txt文件
          File newFile = new File(file,"a.txt");
        	//4.创建这个文件
          newFile.createNewFile();
      }
  }
  ```

### 2.7File类练习二【应用】

- 案例需求

  删除一个多级文件夹

- 实现步骤

  - 定义一个方法,接收一个File对象
  - 遍历这个File对象,获取它下边的每个文件和文件夹对象
  - 判断当前遍历到的File对象是文件还是文件夹
  - 如果是文件,直接删除
  - 如果是文件夹,递归调用自己,将当前遍历到的File对象当做参数传递
  - 参数传递过来的文件夹File对象已经处理完成,最后直接删除这个空文件夹

- 代码实现

  ```java
  public class Test2 {
      public static void main(String[] args) {
          //练习二：删除一个多级文件夹
          //delete方法
          //只能删除文件和空文件夹.
          //如果现在要删除一个有内容的文件夹?
          //先删掉这个文件夹里面所有的内容.
          //最后再删除这个文件夹
  
          File src = new File("C:\\Users\\apple\\Desktop\\src");
          deleteDir(src);
      }
    
  	//1.定义一个方法,接收一个File对象
      private static void deleteDir(File src) {
          //先删掉这个文件夹里面所有的内容.
          //递归 方法在方法体中自己调用自己.
          //注意: 可以解决所有文件夹和递归相结合的题目
          //2.遍历这个File对象,获取它下边的每个文件和文件夹对象
          File[] files = src.listFiles();
          //3.判断当前遍历到的File对象是文件还是文件夹
          for (File file : files) {
              //4.如果是文件,直接删除
              if(file.isFile()){
                  file.delete();
              }else{
                  //5.如果是文件夹,递归调用自己,将当前遍历到的File对象当做参数传递
                  deleteDir(file);//参数一定要是src文件夹里面的文件夹File对象
              }
          }
          //6.参数传递过来的文件夹File对象已经处理完成,最后直接删除这个空文件夹
          src.delete();
      }
  
  }
  ```

### 2.8File类练习三【应用】

- 案例需求

  统计一个文件夹中每种文件的个数并打印

  打印格式如下：

    			txt:3个

    			doc:4个

    			jpg:6个

   			 …

- 实现步骤

  - 定义一个方法,参数是HashMap集合用来统计次数和File对象要统计的文件夹
  - 遍历File对象,获取它下边的每一个文件和文件夹对象
  - 判断当前File对象是文件还是文件夹
  - 如果是文件,判断这种类型文件后缀名在HashMap集合中是否出现过
    - 没出现过,将这种类型文件的后缀名存入集合中,次数存1
    - 出现过,获取这种类型文件的后缀名出现的次数,对其+1,在存回集合中
  - 如果是文件夹,递归调用自己,HashMap集合就是参数集合,File对象是当前文件夹对象

- 代码实现

  ```java
  public class Test3 {
      public static void main(String[] args) {
          //统计一个文件夹中,每种文件出现的次数.
          //统计 --- 定义一个变量用来统计. ---- 弊端:同时只能统计一种文件
          //利用map集合进行数据统计,键 --- 文件后缀名  值 ----  次数
  
          File file = new File("filemodule");
          HashMap<String, Integer> hm = new HashMap<>();
          getCount(hm, file);
          System.out.println(hm);
      }
    
  	//1.定义一个方法,参数是HashMap集合用来统计次数和File对象要统计的文件夹
      private static void getCount(HashMap<String, Integer> hm, File file) {
        	//2.遍历File对象,获取它下边的每一个文件和文件夹对象
          File[] files = file.listFiles();
          for (File f : files) {
            	//3.判断当前File对象是文件还是文件夹
              if(f.isFile()){
                	//如果是文件,判断这种类型文件后缀名在HashMap集合中是否出现过
                  String fileName = f.getName();
                  String[] fileNameArr = fileName.split("\\.");
                  if(fileNameArr.length == 2){
                      String fileEndName = fileNameArr[1];
                      if(hm.containsKey(fileEndName)){
                          //出现过,获取这种类型文件的后缀名出现的次数,对其+1,在存回集合中
                          Integer count = hm.get(fileEndName);
                          //这种文件又出现了一次.
                          count++;
                          //把已经出现的次数给覆盖掉.
                          hm.put(fileEndName,count);
                      }else{
                          // 没出现过,将这种类型文件的后缀名存入集合中,次数存1
                          hm.put(fileEndName,1);
                      }
                  }
              }else{
                //如果是文件夹,递归调用自己,HashMap集合就是参数集合,File对象是当前文件夹对象代码实现
                  getCount(hm,f);
              }
          }
      }
    
  }
  ```

## 

