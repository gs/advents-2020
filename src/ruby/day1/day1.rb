# https://www.youtube.com/watch?v=9ITiZ88sljA&list=PLhYmIiHOMWoGIMCmCRwMSrWkHJg12vevR
# https://adventofcode.com/2020/day/1
require 'byebug'

def read_file
  file = File.open("input.txt")
  file.readlines.map(&:chomp)
end


def find_numbers_that_sums_to_2020
  numbers = read_file
  matched_numbers = []
  numbers.each do |number|
    numbers.each do |number2|
      numbers.each do |number3|
        if number.to_i + number2.to_i + number3.to_i == 2020
          matched_numbers << [number.to_i, number2.to_i]
        end
      end
    end
  end
  matched_numbers.flatten.uniq!
end

numbers = find_numbers_that_sums_to_2020.uniq
puts numbers
sum = numbers[0].to_i * numbers[1].to_i * numbers[2].to_i
puts "sum #{sum}"
