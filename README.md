# 🚀 Remote Command Executor using Java RMI  

This project implements a **CLI-based Remote Command Executor** using **Java RMI (Remote Method Invocation)**. The system allows a client to send shell commands to a remote server, execute them, and display the results on the client machine.

---

## 📌 **Problem Statement**  
Implement a CLI-based remote command executor to execute any command on a remote machine and display the result on the local machine using **Java RMI** for inter-process communication (IPC).  

### ✅ **Requirements**  
- Use **Java RMI** for communication.  
- Create the following classes on the **Server Side**:
  - `RemoteCommandIntf.java`
  - `RemoteCommandImpl.java`
  - `RemoteCommandServer.java`  
- Create the following class on the **Client Side**:
  - `RemoteCommandClient.java`  
- The client should take the **IP address** and **port number** of the RMI Registry as command-line arguments.  
- The client should continue to accept commands until the user types `"bye"`.  

---

## 🏗️ **Project Structure**  

```
├── src
│   ├── RemoteCommandIntf.java
│   ├── RemoteCommandImpl.java
│   ├── RemoteCommandServer.java
│   └── RemoteCommandClient.java
├── README.md
└── .gitignore
```

---

## 🚀 **How to Run**  

### ✅ **1. Compile the Code**  
```bash
javac *.java
```

---

### ✅ **2. Start the RMI Registry**  
- Open a terminal and run:  
```bash
rmiregistry
```

---

### ✅ **3. Start the Server**  
- Run the server with:  
```bash
java RemoteCommandServer
```

---

### ✅ **4. Start the Client**  
- Open a new terminal and run:  
```bash
java RemoteCommandClient <server-ip> <port>
```

---

### ✅ **5. Execute Commands**  
- Example commands:  
```bash
> ls
> date
> uname -a
> bye
```

---

## 📂 **Sample Output**  

```bash
> ls
README.md
RemoteCommandClient.java
RemoteCommandImpl.java
RemoteCommandIntf.java
RemoteCommandServer.java

> date
Sat Mar 8 14:32:10 IST 2025

> uname -a
Linux ubuntu 5.4.0-91-generic #102-Ubuntu SMP Mon Oct 18 14:00:11 UTC 2021 x86_64 x86_64 x86_64 GNU/Linux

> bye
Connection closed.
```

---

## ⚠️ **Notes**  
- Ensure that the **RMI registry** is running before starting the server.  
- The `RemoteCommandImpl` class uses `Runtime.exec()` to execute shell commands, which may have platform-specific behavior.  
- The `"bye"` command will terminate the client session.  

---

## ✅ **Technologies Used**  
- **Java RMI**  
- **ProcessBuilder**  
- **BufferedReader**  
- **Exception Handling**  

---

## 🎯 **Challenges and Solutions**  
| Challenge | Solution |
|----------|----------|
| Handling multi-line command output | Used `BufferedReader` to read process output |
| Maintaining session until "bye" | Continuous loop with exit condition |
| Network failures | Added exception handling for `RemoteException` |

---

## 📌 **Potential Enhancements**  
✅ Add authentication for secure command execution.  
✅ Add support for custom shell environments.  
✅ Display detailed error messages for failed commands.  
