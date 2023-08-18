import socket
import os

HOST = '127.0.0.1'
PORT = 50007

'''#def main():
    while True:
        try:
            mail = ""  # str(input("Введите адрес электронной почты:\n"))
            sms_text = ""  # str(input("Чего изволите отправить:\n"))
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.connect((HOST, PORT))
                s.sendall(b'Hello, world')
                data = s.recv(1024)
            print('Received', repr(data))
            print("OK")
            os.system("pause")
            return 0
        except...:
            print("NOT OK. Try again.\n")




#main()'''


def client_program():
    host = socket.gethostname()
    port = 5000
    client_socket = socket.socket()
    client_socket.connect((host, port))
    message = input(" -> ")
    while message.lower().strip() != 'bye':
        client_socket.send(message.encode())
        data = client_socket.recv(1024).decode()
        print('Received from server: ' + data)
        message = input(" -> ")
    client_socket.close()


if __name__ == '__main__': client_program()
