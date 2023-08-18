import socket

HOST = '127.0.0.1'
PORT = 50007

'''def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen(1)
        conn, addr = s.accept()
        with conn:
            print('Connected by', addr)
        while True:
            data = conn.recv(1024)
        if not data:
            return 0
        conn.sendall(data)


main()'''


def server_program():  # get the hostname
    host: str = socket.gethostname()
    port = 5000  # initiate port no above 1024
    server_socket = socket.socket()
    server_socket.bind((host, port))
    server_socket.listen(2)
    conn, address = server_socket.accept()
    print("Connection from: " + str(address))
    while True:
        data = conn.recv(1024).decode()
        if not data:
            break
        print("from connected user: " + str(data))
        data = input(' -> ')
        conn.send(data.encode())  # send data to the client
        conn.close()


if __name__ == '__main__': server_program()
