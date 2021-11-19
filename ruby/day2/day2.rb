# https://adventofcode.com/2020/day/2
# common code
def read_file
  file = File.open("input.txt")
  file.readlines.map(&:chomp)
end

def messages
  ["1-3 c: abcd", "1-3 b: acbcd", "1-3 x: acbcd"]
end

def split_message_to_array(message)
  occurences, letter, password = message.split(" ")
  letter = letter.split(":")[0]
  occurences = occurences.split("-")
  [occurences, letter, password]
end


# part 1
def is_password_valid_part_1
  valid_passwords = []
  read_file.each do |message|
    occurences, letter, password = split_message_to_array(message)
    valid_passwords << password.count(letter).between?(occurences[0].to_i, occurences[1].to_i)
  end
  valid_passwords.count(true)
end

# part 2
def get_letter_precise_postions(letter="c", password="abccd")
  positions = []
  password = password.split("")
  password.each_with_index do |s, i|
    if letter == s
      positions << i+1
    end
  end
  positions
end

def is_password_valid_part_2
  valid_passwords = []
  read_file.each do |message|
    occurences, letter, password = split_message_to_array(message)
    letter_positions = get_letter_precise_postions(letter, password)
    valid_passwords << (occurences.map(&:to_i) & letter_positions).length  == 1
  end
  valid_passwords.count(1)
end
puts "Part 1  = #{is_password_valid_part_1}"
puts "------------------"
puts "Part 2  = #{is_password_valid_part_2}"

